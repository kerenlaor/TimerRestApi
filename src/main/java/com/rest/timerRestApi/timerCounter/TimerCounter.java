package com.rest.timerRestApi.timerCounter;

import java.util.Map;

import com.rest.timerRestApi.controllers.TimerController;
import com.schemas.modelRest.TimerData;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class TimerCounter extends Thread{
    private Map<Integer, Map<String, TimerData>> timers;
    private String timerId;
    private int pageNumber;
    private int totalAmountOfTimer;
    private int timeLeft;

    @Override
    public void run() {
        Logger logger = LoggerFactory.getLogger(TimerCounter.class);
        WebHookSender webHookSender = new WebHookSender();
        TimerData timerData = timers.get(pageNumber).get(timerId);
        while(timeLeft > 0) {
            try {
                Thread.sleep(1000);
                timeLeft --;
                logger.warn("{} seconds left for timer {}", timeLeft, timerId);
                if(timers != null) {
                    timerData.setTimeLeft(timeLeft);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        logger.warn("timer {} finished", timerId);
        webHookSender.sendWebhook(timerData.getWebhookUrl());
        if(timers != null) {
            timerData.setTimeLeft(0);
            timerData.setStatus(TimerData.StatusEnum.FINISHED);
        }
    }
}
