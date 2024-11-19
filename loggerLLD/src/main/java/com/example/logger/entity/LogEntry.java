package com.example.logger.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
//@Table("log_entries")
@Data
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String level;

    @Column(nullable = false)
    private String message;

    private LocalDateTime timestamp;

    LogEntry(){
    }

    public LogEntry(String level, String message){
        this.level=level;
        this.message= message;
        this.timestamp=LocalDateTime.now();

    }
}
