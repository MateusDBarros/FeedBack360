package dev.project.feedback360.models.FeedbackSession;

import dev.project.feedback360.models.Users.Team;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FSRequest(
        @NotBlank String title,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate,
        @NotNull Team team
        ) {
}
