package com.example.pomogranate.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.pomogranate.Session;

public class SessionRepository {

    
    public void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS sessions (id INTEGER PRIMARY KEY AUTOINCREMENT, completed_at TEXT)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute();
        }

    }

    public void recordSessionCompletion() throws SQLException {

        String sql = "INSERT INTO sessions (completed_at) VALUES (?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, LocalDateTime.now().toString());
            pstmt.executeUpdate();
        }

    }

    public List<Session> getAllSessions() throws SQLException {
        String sql = "SELECT * FROM sessions";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            List<Session> sessions = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String completedAt = rs.getString("completed_at");
                sessions.add(new Session(id, completedAt));
            }
            return sessions;
        }
    }
}