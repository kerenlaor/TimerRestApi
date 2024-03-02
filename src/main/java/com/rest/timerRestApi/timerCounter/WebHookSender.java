package com.rest.timerRestApi.timerCounter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebHookSender {
    Logger logger = LoggerFactory.getLogger(WebHookSender.class);
    public void sendWebhook(String webhookUrl) {
        try {
            URL url = new URL(webhookUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method and headers
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            // Enable output and send empty body
            connection.setDoOutput(true);
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write("".getBytes());
            outputStream.flush();
            outputStream.close();

            int responseCode = connection.getResponseCode();
            logger.warn("webhook send, Response Code is {} ", responseCode);

            // Close connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
