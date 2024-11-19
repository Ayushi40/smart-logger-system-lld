package com.example.logger.strategy;

import com.example.logger.entity.LogEntry;

public interface LogStrategy {
    void log(LogEntry entry);
//    void log(String message);
}
