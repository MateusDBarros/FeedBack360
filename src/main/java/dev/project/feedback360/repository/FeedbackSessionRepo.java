package dev.project.feedback360.repository;

import dev.project.feedback360.models.FeedbackSession.FeedbackSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackSessionRepo extends JpaRepository<FeedbackSession, Long> {
}
