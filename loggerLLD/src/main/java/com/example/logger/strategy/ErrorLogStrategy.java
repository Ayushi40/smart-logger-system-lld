package com.example.logger.strategy;

import com.example.logger.entity.LogEntry;
import com.example.logger.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ErrorLogStrategy implements LogStrategy{
    @Autowired
    private LogRepository logRepository;

    @Override
    public void log(LogEntry entry) {
        System.out.println(entry.getTimestamp()+" [APP/PROC/WEB/0] OUT ''"+"ERROR | "+ entry.getMessage());
    }

//    @Override
//    public void log(String message) {
//        logRepository.save(new LogEntry("ERROR", message));
//    }
}
