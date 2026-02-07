package com.Makylone.HeartBeat.Controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

import com.Makylone.HeartBeat.Model.StatusReponse;

public class HeartBeatController {
    public StatusReponse sendHearbeats(String url) throws IOException, InterruptedException{
        
        HttpClient client = HttpClient.newHttpClient();
        long startTime = System.nanoTime();
        HttpRequest request = HttpRequest.newBuilder()
                                            .uri(URI.create(url))
                                            .GET()
                                            .build();
        HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
        long elapsedTime  =  System.nanoTime() - startTime;
        long responseTime = TimeUnit.NANOSECONDS.toMillis(elapsedTime);
        return new StatusReponse(response.statusCode(), url, responseTime);
    }
}