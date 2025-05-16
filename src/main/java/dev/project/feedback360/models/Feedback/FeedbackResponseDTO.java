package dev.project.feedback360.models.Feedback;

import java.time.LocalDate;

public record FeedbackResponseDTO(
        String comment,
        LocalDate date
) {
}
