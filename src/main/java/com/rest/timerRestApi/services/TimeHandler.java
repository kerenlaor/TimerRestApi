package com.rest.timerRestApi.services;

import com.rest.timerRestApi.timerCounter.TimerCounter;
import com.rest.timerRestApi.utilities.TimeCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.schemas.modelRest.TimerCountdownResponse;
import com.schemas.modelRest.TimerRequest;
import com.schemas.modelRest.TimerResponse;
import com.schemas.modelRest.TimerData;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TimeHandler {

    private static final int MAX_TIMERS_PER_PAGE = 5;
    private final Logger logger = LoggerFactory.getLogger(TimeHandler.class);
    private int lastPage = 0;
    private Map<Integer, Map<String, TimerData>> idToTimerMap = new HashMap<>();
    public TimerCountdownResponse addTime(TimerRequest timerRequest, LocalDateTime date) {
        String timeUuid = UUID.randomUUID().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String dateFormated = date.format(formatter);
        logger.warn("adding new timerData {} to timers map from request", timeUuid);
        int hours = timerRequest.getHours();
        int minutes = timerRequest.getMinutes();
        int seconds = timerRequest.getSeconds();
        int totalNumberOfSeconds = TimeCalculator.calculateTotalNumberOfSeconds(hours, minutes, seconds);
        TimerData timerData = new TimerData()
                .id(timeUuid)
                        .dateCreated(dateFormated)
                .hours(timerRequest.getHours())
                .minutes(timerRequest.getMinutes())
                .seconds(timerRequest.getSeconds())
                .status(TimerData.StatusEnum.STARTED)
                .timeLeft(totalNumberOfSeconds)
                .webhookUrl(timerRequest.getWebhookUrl());

        addTimeToPage(timeUuid, timerData);
        logger.warn("timer {} was added successfully to map {}", timeUuid, idToTimerMap);

        TimerCountdownResponse timerCountdownResponse = new TimerCountdownResponse()
                .id(timeUuid)
                .numberOfSecondsLeft(totalNumberOfSeconds);
        Thread timerCountDown = new TimerCounter(
                idToTimerMap,
                timeUuid,
                lastPage,
                totalNumberOfSeconds,
                totalNumberOfSeconds);
        timerCountDown.setDaemon(true);
        timerCountDown.start();

        return timerCountdownResponse;
    }

    public TimerResponse getAllTimersInPage(int pageNumber) {
        Map<String, TimerData> timersInPage = idToTimerMap.get(pageNumber);
        TimerResponse timerResponse = new TimerResponse();
        timerResponse.setPageNumber(pageNumber);
        timerResponse.setPageSize(MAX_TIMERS_PER_PAGE);
        timerResponse.setTotalRowCount(timersInPage.size());
        timerResponse.setTimers(timersInPage.values().stream().toList());
        return timerResponse;
    }

    public TimerCountdownResponse getTimerById(String timerId, int pageNumber){
        TimerData timerData = idToTimerMap.get(pageNumber).get(timerId);
        if(timerData == null) {
            return null;
        }
        return new TimerCountdownResponse()
                .id(timerId)
                .numberOfSecondsLeft(timerData.getTimeLeft());
    }

    private void addTimeToPage(String timerUuid, TimerData timerData) {
        if(idToTimerMap.isEmpty()) {
            createNewPage();
        }

        addNewTimer(timerUuid, timerData);
    }

    private void createNewPage() {
        lastPage++;
        idToTimerMap.put(lastPage, new HashMap<>());
        logger.debug("page {} created", lastPage);
    }

    private void addNewTimer(String timerUuid, TimerData timerData) {
        Map<String, TimerData> lastPageMap = idToTimerMap.get(lastPage);
        if(lastPageMap.size() < MAX_TIMERS_PER_PAGE) {
            logger.debug("adding timer {} to page {}", timerUuid, lastPage);
            lastPageMap.put(timerUuid, timerData);
        } else {
            logger.debug("page {} is to loaded", lastPage);
            createNewPage();
            idToTimerMap.get(lastPage).put(timerUuid, timerData);
            logger.debug("adding timer {} to page {}", timerUuid, lastPage);
        }
    }
}
