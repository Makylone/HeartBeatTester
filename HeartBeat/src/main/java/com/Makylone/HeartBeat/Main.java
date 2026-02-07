package com.Makylone.HeartBeat;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.Makylone.HeartBeat.Controller.HeartBeatController;
import com.Makylone.HeartBeat.Model.StatusReponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        if(args.length > 0){
            ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
            for (String url : args) {
                Future<?> future = executorService.submit(() -> {
                    
                        HeartBeatController heartBeatController = new HeartBeatController();
                        StatusReponse sr;
                        try {
                            sr = heartBeatController.sendHearbeats(url);
                            System.out.println(sr.status() + " " + sr.url() + " " + sr.responseTime() + "ms");
                        } catch (IOException | InterruptedException ex) {
                            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                        }
                    
                    
                });
                future.get();
            }
        }
    }
}
