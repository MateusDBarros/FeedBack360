package dev.project.feedback360.service;

import dev.project.feedback360.models.Users.User;
import dev.project.feedback360.models.Users.UserResponseDTO;
import dev.project.feedback360.models.Users.UserRequest;
import dev.project.feedback360.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponseDTO createUser(UserRequest request) {

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setTeam(request.team());
        user.setRole(request.role());
        repository.save(user);

        return new UserResponseDTO(user.getId(), user.getTeam(), user.getEmail());
    }

    public List<UserResponseDTO> listUser() {
        return repository.findAll().stream().map(user -> new UserResponseDTO(user.getId(), user.getTeam(), user.getEmail())).toList();
    }

    @Transactional
    public UserResponseDTO updateUser(Long id, UserRequest request) {
        User user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario não existe"));

        user.setName(request.name());
        user.setEmail(request.email());
        user.setTeam(request.team());
        user.setRole(request.role());

        repository.save(user);

        return new  UserResponseDTO(user.getId(), user.getTeam(), user.getEmail());
    }

    public void deleteUser(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException("Usuario não existe");
    }
}
