package dev.project.feedback360.controller;

import dev.project.feedback360.models.FeedbackSession.FSRequest;
import dev.project.feedback360.models.FeedbackSession.FSResponse;
import dev.project.feedback360.service.FeedbackSessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback-sessions")
public class FeedbackSessionController {

    private final FeedbackSessionService service;

    public FeedbackSessionController(FeedbackSessionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FSResponse> addSession(@Valid @RequestBody FSRequest request) {
        FSResponse response = service.addSession(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<FSResponse>> listSessions() {
        return ResponseEntity.ok(service.listSessions());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteSessions() {
        service.DeleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Todas as sessões foram deletada com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@RequestParam Long id) {
        service.deleteById(id);
        return ResponseEntity.ok(String.format("Sessão com ID %d deletado com sucesso", id));
    }
}
