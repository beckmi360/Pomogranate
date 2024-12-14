package com.example.pomogranate;

import com.example.pomogranate.database.SessionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class PomogranateApplication {
    public static void main(String[] args) {
        SpringApplication.run(PomogranateApplication.class, args);
    }

    @Bean
    public SessionRepository sessionRepository() throws SQLException {
        SessionRepository sessionRepository = new SessionRepository();
        sessionRepository.createTable();
        return sessionRepository;
    }
}