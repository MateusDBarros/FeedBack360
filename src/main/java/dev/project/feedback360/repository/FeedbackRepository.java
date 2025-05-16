package dev.project.feedback360.repository;

import dev.project.feedback360.models.Feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
