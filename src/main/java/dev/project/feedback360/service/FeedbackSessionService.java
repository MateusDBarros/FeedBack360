package dev.project.feedback360.service;

import dev.project.feedback360.models.FeedbackSession.FSRequest;
import dev.project.feedback360.models.FeedbackSession.FSResponse;
import dev.project.feedback360.models.FeedbackSession.FeedbackSession;
import dev.project.feedback360.repository.FeedbackSessionRepo;
import org.springframework.stereotype.Service;

@Service
public class FeedbackSessionService {

    private final FeedbackSessionRepo repository;

    public FeedbackSessionService(FeedbackSessionRepo repository) {
        this.repository = repository;
    }

    public FSResponse addSession(FSRequest request) {

        FeedbackSession session = new FeedbackSession();

        session.setTitle(request.title());
        session.setStartDate(request.startDate());
        session.setEndDate(request.endDate());
        session.setTeam(request.team());

        repository.save(session);

        return new FSResponse(session.getTitle(), session.getId(), session.getTeam());
    }



}
