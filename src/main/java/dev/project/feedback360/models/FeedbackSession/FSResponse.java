package dev.project.feedback360.models.FeedbackSession;

import dev.project.feedback360.models.Users.Team;

public record FSResponse(
        String title,
        Long id,
        Team team
) {
}
