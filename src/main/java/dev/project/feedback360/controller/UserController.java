package dev.project.feedback360.controller;


import dev.project.feedback360.models.Users.UserRequest;
import dev.project.feedback360.models.Users.UserResponseDTO;
import dev.project.feedback360.service.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequest request) {
        UserResponseDTO user = service.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
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
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.ok(String.format("Usuario com ID: %d deletado com sucesso!", id));
    }
}
