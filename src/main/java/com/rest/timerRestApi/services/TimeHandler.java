package com.rest.timerRestApi.services;

import com.rest.timerRestApi.models.Status;
import com.rest.timerRestApi.models.TimerData;
import com.rest.timerRestApi.utilities.TimeCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import target.src.main.java.com.schemas.modelRest.TimerCountdownResponse;
import target.src.main.java.com.schemas.modelRest.TimerRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TimeHandler {

    Logger logger = LoggerFactory.getLogger(TimeHandler.class);
    Map<String, TimerData> idToTimerMap = new HashMap<>();
    public TimerCountdownResponse addTime(TimerRequest timerRequest, LocalDateTime date) {
        String timeUuid = UUID.randomUUID().toString();
        logger.warn("adding new timerData {} to timers map from request", timeUuid);
        int hours = timerRequest.getHours();
        int minutes = timerRequest.getMinutes();
        int seconds = timerRequest.getSeconds();
        int totalNumberOfSeconds = TimeCalculator.calculateTotalNumberOfSeconds(hours, minutes, seconds);
        idToTimerMap.put(timeUuid, new TimerData(timeUuid,
                date,
                hours,
                minutes,
                seconds,
                totalNumberOfSeconds,
                timerRequest.getWebhookUrl(),
                Status.STARTED,
                totalNumberOfSeconds)
        );

        logger.warn("timer {} was added successfully to map {}", timeUuid, idToTimerMap);

        TimerCountdownResponse timerCountdownResponse = new TimerCountdownResponse()
                .id(timeUuid)
                .numberOfSecondsLeft(totalNumberOfSeconds);

        return timerCountdownResponse;
    }
}
