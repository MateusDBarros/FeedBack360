package dev.project.feedback360.models.Feedback;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FeedbackRequest(

        @NotBlank String comment,
        @NotNull Long userId) {
}
