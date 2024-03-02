package com.rest.timerRestApi.models;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TimerDataModel {
    private String Id;
    private LocalDateTime createdDate;
    private int hours;
    private int minutes;
    private int seconds;
    private int timeLeft;
    private String webhookHookUrl;
    private Status status;
    private int totalNumberOfSeconds;
}

