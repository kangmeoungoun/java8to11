package me.goldapple.java8to11;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args){
        /* 쓰레드
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(getRunnable("Hello"));
        executorService.execute(getRunnable("kmo"));
        executorService.execute(getRunnable("The"));
        executorService.execute(getRunnable("java"));
        executorService.execute(getRunnable("thread"));
        */
        //executorService 셧다운을 하지 않으면 계속 프로그램이 살아 있음
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();



        executorService.scheduleAtFixedRate(getRunnable("Hello"), 3,2,TimeUnit.SECONDS);
        //executorService.shutdown();

    }

    private static Runnable getRunnable(String message){
        return () -> {
            System.out.println(message + Thread.currentThread().getName());
        };
    }
}
