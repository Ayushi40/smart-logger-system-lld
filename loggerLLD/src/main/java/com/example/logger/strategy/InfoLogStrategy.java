package com.example.logger.strategy;

import com.example.logger.entity.LogEntry;
import com.example.logger.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoLogStrategy implements LogStrategy{
    @Autowired
    private LogRepository logRepository;

//    @Override
//    public void log(String message) {
//        logRepository.save(new LogEntry("INFO",message));
//
//    }

    @Override
    public void log(LogEntry entry) {
        System.out.println(entry.getTimestamp()+" [APP/PROC/WEB/0] OUT ''"+"INFO | "+ entry.getMessage());
    }
}
