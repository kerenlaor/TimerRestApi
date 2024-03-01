package com.rest.timerRestApi.controllers;

import com.rest.timerRestApi.services.TimeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.schemas.modelRest.TimerCountdownResponse;
import com.schemas.modelRest.TimerRequest;
import com.schemas.timerRest.ApiRest;

import java.time.LocalDateTime;

@RestController
public class TimerController implements ApiRest {
    Logger logger = LoggerFactory.getLogger(TimerController.class);
    @Autowired
    TimeHandler timerHandler;

    @Override
    public ResponseEntity<TimerCountdownResponse> startNewTimerCountdown(com.schemas.modelRest.TimerRequest timerRequest) {
        logger.warn("timer request is {}", timerRequest);
        LocalDateTime currentTime = LocalDateTime.now();
        TimerCountdownResponse timerCountdownResponse = timerHandler.addTime(timerRequest, currentTime);
        return new ResponseEntity<>(timerCountdownResponse, HttpStatus.OK);
    }
}

