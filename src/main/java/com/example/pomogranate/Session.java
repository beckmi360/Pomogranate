package com.example.pomogranate;

public class Session {
    private int id;
    private String completedAt;

    public Session(int id, String completedAt) {
        this.id = id;
        this.completedAt = completedAt;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getCompletedAt(){
        return completedAt;
    }
    public void setCompletedAt(String completedAt){
        this.completedAt = completedAt;
    }
}