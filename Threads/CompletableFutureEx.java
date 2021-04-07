package com.mph;


import java.util.concurrent.CompletableFuture;

public class CompletableFutureEx {

    public static int compute() {
        //task executed by a thread in fork join pool
        System.out.println("Inside compute : " + Thread.currentThread());
        return 2;
    }

    public static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(() -> compute());
        //other way to return it CompletableFuture.supplyAsync(CompletableFutureEx::compute)

    }

    public static CompletableFuture<Integer> create(int number) {
        return CompletableFuture.supplyAsync(() -> number);

    }

    public static void print(int data) {
        System.out.println("Inside print : " + Thread.currentThread());
        System.out.println(data);
    }


    public static void main(String[] args) {

        CompletableFuture<Integer> cf = new CompletableFuture<>();

        process(cf);
        cf.complete(5);
        create(3).thenCombine(create(4), (result1, result2) -> result1 + result2)
                .thenAccept(SumResult -> System.out.println(SumResult));


        System.out.println("End"); //in Future it cannot be done since the main thread would be blocked
    }

    private static void process(CompletableFuture<Integer> cf) {
        cf
                .thenApply(value -> value / 5)
                .exceptionally(throwable -> handle(throwable))
                .thenApply(value -> value + 1)
                .thenAccept(result -> System.out.println(result));

    }

    private static int handle(Throwable throwable) {
        System.out.println("ERROR: " + throwable);
        //throw new RuntimeException(); u can prefer to rethrow an exception
        return 1;//it replaces the result value
    }


}


