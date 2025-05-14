package dev.project.feedback360.models.UserEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank String name,
        @Email String email,
        @NotBlank Team team,
        @NotBlank String role
) {
}
