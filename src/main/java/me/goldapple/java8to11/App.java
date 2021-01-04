package me.goldapple.java8to11;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        //CompletableFuture<String> future = new CompletableFuture<>();
        //future.complete("kmo");
        //CompletableFuture<String> future = CompletableFuture.completedFuture("kmo");
        //리턴 없을때
        //
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        //CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> System.out.println("hello" + Thread.currentThread().getName()));
        //voidCompletableFuture.get();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello" + Thread.currentThread().getName());
            return "hello";
        },executorService).thenApplyAsync((s)->{//콜백 리턴값으로 어떤걸 할때
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        },executorService);
        //thenAccept() 리턴 없을떄
        future.get();

    }



}
