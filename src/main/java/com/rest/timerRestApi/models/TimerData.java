package com.rest.timerRestApi.models;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TimerData {
    private String Id;
    private LocalDateTime dateCreated;
    private int hours;
    private int minutes;
    private int seconds;
    private int timeLeft;
    private String webhookHookUrl;
    private Status status;
    private int totalNumberOfSeconds;
}

