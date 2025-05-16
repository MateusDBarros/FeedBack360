package dev.project.feedback360.service;

import dev.project.feedback360.models.Feedback.Feedback;
import dev.project.feedback360.models.Feedback.FeedbackRequest;
import dev.project.feedback360.models.Feedback.FeedbackResponseDTO;
import dev.project.feedback360.models.Users.User;
import dev.project.feedback360.models.Users.UserResponseDTO;
import dev.project.feedback360.repository.FeedbackRepository;
import dev.project.feedback360.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository repository;
    private final UserRepository userRepository;

    public FeedbackService(FeedbackRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public FeedbackResponseDTO addFeedback(FeedbackRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        Feedback feedback = new Feedback();
        feedback.setComment(request.comment());
        feedback.setUser(user);
        feedback.setDate(LocalDate.now());

        repository.save(feedback);

        return new FeedbackResponseDTO(feedback.getComment(), feedback.getDate());
    }


    public void deleteFeedbackById(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException("Feedback não encontrado");
    }

    public void deleteAllFeedbacks() {
        repository.deleteAll();
    }

    public List<FeedbackResponseDTO> listFeedback() {
        return repository.findAll().stream().map(feedback -> new FeedbackResponseDTO(feedback.getComment(), feedback.getDate())).toList();
    }

}
