package me.goldapple.java8to11;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException{

        //둘 사이의 의존 관계과 있을때
        /*
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()->{
            System.out.println("Hello "+Thread.currentThread().getName());
            return "Hello";
        });
        CompletableFuture<String> future = hello.thenCompose(App :: getWorld);
        System.out.println(future.get());
        */
        //둘 사이의 의존 관계과 없을때
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()->{
            System.out.println("Hello" + Thread.currentThread().getName());
            return " Hello";
        });
        CompletableFuture<String> world = CompletableFuture.supplyAsync(()->{
            System.out.println("World "+Thread.currentThread().getName());
            return "World";
        });
        CompletableFuture<String> future = hello.thenCombine(world , (h , w) -> {
            return h + w;
        });

        //모든 타입 합쳐서 출력
        List<CompletableFuture<String>> futures = Arrays.asList(hello , world);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<List<String>> results = CompletableFuture.allOf(futures.toArray(futuresArray))
                .thenApply((v) -> {
                    return futures.stream()
                            .map(CompletableFuture :: join)
                            .collect(Collectors.toList());
                });
        results.get().forEach(System.out :: println);

        //아무거나 먼저온놈 하나 출력
        CompletableFuture<Void> future1 = CompletableFuture.anyOf(hello , world).thenAccept(System.out :: println);
        future1.get();

        //에러가 발생하면
        boolean throwError = true;
        CompletableFuture<String> hello1 = CompletableFuture.supplyAsync(()->{
            if(throwError){
                throw new IllegalArgumentException();
            }
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        })
//           .exceptionally(ex->{ //에러 났을때
//            System.out.println(ex.toString());
//            return "Error";
//        })
                .handle((result,ex)->{
                    if(ex!=null){
                        return "ERROR";
                    }
                    return result;
                }); //에러 났을때 ,정상 처리 둘다

        System.out.println(hello1.get());



    }


    private static CompletableFuture<String> getWorld(String message){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World" + Thread.currentThread().getName());
            return message+" World";
        });
    }


}
