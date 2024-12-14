package com.example.pomogranate;

import com.example.pomogranate.database.SessionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {
    private final SessionRepository sessionRepository;

    public SessionController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @PostMapping
    public void recordSessionCompletion() throws SQLException {
        sessionRepository.recordSessionCompletion();
        System.out.println("Session completed and recorded in the database.");
    }

    @GetMapping
    public List<Session> getSessions() throws SQLException {
        return sessionRepository.getAllSessions();
    }
}