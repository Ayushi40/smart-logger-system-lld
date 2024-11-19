package com.example.logger.factory;

import com.example.logger.entity.LogEntry;

/**
Factory Pattern: Encapsulates the creation of
log entries based on type (INFO, WARN, ERROR) in separate
factory classes, which makes it easy to add new log types.
 */

public interface LogFactory {
     LogEntry createLog(String message);
}
