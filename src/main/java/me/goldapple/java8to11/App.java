package me.goldapple.java8to11;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = ()->{
          Thread.sleep(3000L);
            System.out.println("hello"+Thread.currentThread().getName());
            return "hello";
        };
        Callable<String> java = ()->{
            Thread.sleep(1000L);
            System.out.println("Java"+Thread.currentThread().getName());
            throw new IllegalStateException();
            //return "Java";
        };
        Callable<String> kmo = ()->{
            Thread.sleep(3000L);
            System.out.println("kmo"+Thread.currentThread().getName());
            return "kmo";
        };
        /*
        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

        //helloFuture.cancel(false); //true 현재 진행중인 작업을 종료 cancel 을 아면 done 은 true
        //helloFuture.get(); //블록킹

        System.out.println(helloFuture.isDone());
        System.out.println("End!");
        */

        //String s = executorService.invokeAny(Arrays.asList(hello , java , kmo));
        //System.out.println(s);
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello , java , kmo));
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }
        executorService.shutdown();
    }



}
