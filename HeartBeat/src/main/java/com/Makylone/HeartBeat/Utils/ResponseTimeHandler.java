package com.Makylone.HeartBeat.Utils;

import java.util.concurrent.TimeUnit;

public class ResponseTimeHandler {
    public static long start(){
        return System.nanoTime();
    }

    public static long stop(long startTimer){
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTimer);
    }
}
