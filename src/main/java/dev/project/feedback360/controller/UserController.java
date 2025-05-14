package dev.project.feedback360.controller;


import dev.project.feedback360.models.UserEntity.UserRequest;
import dev.project.feedback360.models.UserEntity.UserResponseDTO;
import dev.project.feedback360.service.UserService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequest request) {
        service.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listAllUsers() {
        List<UserResponseDTO> users = service.listUser();

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequest request) {
        UserResponseDTO userResponse = service.updateUser(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUSer(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario com ID:" +id+ " excluido com sucesso");
    }
}
