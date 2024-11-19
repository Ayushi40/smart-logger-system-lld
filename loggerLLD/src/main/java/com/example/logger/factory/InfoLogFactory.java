package com.example.logger.factory;

import com.example.logger.entity.LogEntry;

public class InfoLogFactory implements LogFactory{
    @Override
    public LogEntry createLog(String message) {
        return new LogEntry("INFO",message);
    }
}
