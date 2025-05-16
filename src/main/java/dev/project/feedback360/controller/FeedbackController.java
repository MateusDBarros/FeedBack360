package dev.project.feedback360.controller;

import dev.project.feedback360.models.Feedback.FeedbackRequest;
import dev.project.feedback360.models.Feedback.FeedbackResponseDTO;
import dev.project.feedback360.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<FeedbackResponseDTO> addFeedback(@Valid @RequestBody FeedbackRequest request) {
        FeedbackResponseDTO responseDTO = service.addFeedback(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<FeedbackResponseDTO>> listFeedbacks() {
        return ResponseEntity.ok(service.getAllFeedbacks());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        service.deleteFeedbackById(id);
        return ResponseEntity.ok(String.format("Feedback com ID: %d deletado com sucesso!", id));
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteAll() {
        service.deleteAllFeedbakcs();
        return ResponseEntity.ok("Todos os Feedbacks foram deletados com sucesso!");
    }
}
