package com.Makylone.HeartBeat.Controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.Makylone.HeartBeat.Model.StatusReponse;
import com.Makylone.HeartBeat.Utils.ResponseTimeHandler;

public class HeartBeatController {

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public StatusReponse sendHearbeats(String url) throws IOException, InterruptedException{
        long startTime = ResponseTimeHandler.start();
        HttpRequest request = HttpRequest.newBuilder()
                                            .uri(URI.create(url))
                                            .GET()
                                            .build();
        HttpResponse<Void> response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
        long responseTime = ResponseTimeHandler.stop(startTime);
        return new StatusReponse(response.statusCode(), url, responseTime);
    }
}