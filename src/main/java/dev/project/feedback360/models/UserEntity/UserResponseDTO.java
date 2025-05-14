package dev.project.feedback360.models.UserEntity;

public record UserResponseDTO(
        Long id,
        Team team,
        String email
) {
}
