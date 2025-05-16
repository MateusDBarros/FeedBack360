package dev.project.feedback360.models.Users;

public record UserResponseDTO(
        Long id,
        Team team,
        String email
) {
}
