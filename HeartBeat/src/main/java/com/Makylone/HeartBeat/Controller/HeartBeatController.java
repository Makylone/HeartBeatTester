package com.Makylone.HeartBeat.Controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.Makylone.HeartBeat.Model.StatusReponse;

public class HeartBeatController {
    public StatusReponse sendHearbeats(String url) throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                            .uri(URI.create(url))
                                            .GET()
                                            .build();
        HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
        
        return new StatusReponse(response.statusCode(), url);
    }
}