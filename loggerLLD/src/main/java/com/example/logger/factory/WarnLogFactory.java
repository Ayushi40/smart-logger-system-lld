package com.example.logger.factory;

import com.example.logger.entity.LogEntry;

public class WarnLogFactory implements LogFactory{
    @Override
    public LogEntry createLog(String message) {
        return new LogEntry("WARN",message);
    }
}
