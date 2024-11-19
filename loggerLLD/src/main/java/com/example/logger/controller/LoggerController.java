package com.example.logger.controller;

import com.example.logger.service.LoggerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LoggerController {

    private final LoggerService loggerService = LoggerService.getInstance();

    @PostMapping("/level/{level}")
    public String logMessage(@PathVariable String level,@RequestBody String message){
        loggerService.log(level,message);
        return "Log Entry created.";
    }
}
