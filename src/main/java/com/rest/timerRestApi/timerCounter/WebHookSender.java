package com.rest.timerRestApi.timerCounter;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.schemas.modelRest.WebhookTimerRequest;
import com.schemas.modelRest.TimerWebhookResponse;

public class WebHookSender {
    Logger logger = LoggerFactory.getLogger(WebHookSender.class);
    public void sendWebhook(String webhookUrl) {
        try {
            Gson gson = new Gson();
            HttpClient client = HttpClient.newHttpClient();
            WebhookTimerRequest webhookTimerRequest = new WebhookTimerRequest().message("notify that timer finished");
            String message = gson.toJson(webhookTimerRequest);
            logger.warn("json message to send is : {}", message);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(webhookUrl))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(message))
                    .build();


            //logger.warn("request body is : {}", HttpRequest.BodyPublishers.ofString(message));
           // logger.warn("");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (SSLException e) {
            logger.error("exception is: {}", e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
