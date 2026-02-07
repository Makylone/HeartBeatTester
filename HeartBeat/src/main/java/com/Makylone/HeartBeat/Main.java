package com.Makylone.HeartBeat;

import java.io.IOException;

import com.Makylone.HeartBeat.Controller.HeartBeatController;
import com.Makylone.HeartBeat.Model.StatusReponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length > 0){
            for (String url : args) {
                HeartBeatController heartBeatController = new HeartBeatController();
                StatusReponse sr = heartBeatController.sendHearbeats(url);
                System.out.println(sr.status() + " " + sr.url() + " " + sr.responseTime() + "ms");
            }
           
        }
    }
}
