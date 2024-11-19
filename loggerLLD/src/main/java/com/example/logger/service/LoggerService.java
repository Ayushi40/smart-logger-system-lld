package com.example.logger.service;

import com.example.logger.entity.LogEntry;
import com.example.logger.factory.ErrorLogFactory;
import com.example.logger.factory.InfoLogFactory;
import com.example.logger.factory.LogFactory;
import com.example.logger.factory.WarnLogFactory;
import com.example.logger.strategy.ErrorLogStrategy;
import com.example.logger.strategy.InfoLogStrategy;
import com.example.logger.strategy.LogStrategy;
import com.example.logger.strategy.WarnLogStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class LoggerService {
    private static LoggerService instance;

    Map<String, LogStrategy> strategyMap = new HashMap<>();
    Map<String , LogFactory> factoryMap = new HashMap<>();

    public LoggerService() {
        // strategy mapping
        strategyMap.put("INFO", new InfoLogStrategy());
        strategyMap.put("WARN", new WarnLogStrategy());
        strategyMap.put("ERROR", new ErrorLogStrategy());

        // factory mapping
        factoryMap.put("INFO", new InfoLogFactory());
        factoryMap.put("WARN", new WarnLogFactory());
        factoryMap.put("ERROR", new ErrorLogFactory());
    }

    public static LoggerService getInstance(){
        if(instance== null){
            instance = new LoggerService();
        }
        return instance;
    }

    public void log(String level, String message){
        LogFactory factory = factoryMap.get(level.toUpperCase(Locale.ROOT));
        LogStrategy strategy = strategyMap.get(level.toUpperCase(Locale.ROOT));

        if(factory != null && strategy != null){
            LogEntry logEntry = factory.createLog(message);
            strategy.log(logEntry);
        }else{
            throw new IllegalArgumentException("Invalid log level: "+level);
        }


    }


//    public LoggerService(List<LogStrategy> strategies){
//        strategies.forEach(strategy -> {
//                    if (strategy instanceof InfoLogStrategy) strategyMap.put("INFO", strategy);
//                    if(strategy instanceof  WarnLogStrategy) strategyMap.put("WARN", strategy);
//                    if(strategy instanceof  ErrorLogStrategy) strategyMap.put("ERROR", strategy);
//                }
//            );
//    }

//    public void log(String level, String message){
//        LogStrategy strategy = strategyMap.get(level.toUpperCase(Locale.ROOT));
//        if(strategy!=null){
//            strategy.log(message);
//        } else{
//            throw new IllegalArgumentException("Invalid Log level: "+ level);
//        }
//    }

}
