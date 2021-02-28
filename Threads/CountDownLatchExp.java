package com.company.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task1 implements Callable<String>{

    private CountDownLatch latch;

    public Task1(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {

       latch.countDown();
        System.out.println(Thread.currentThread().getName());
        return Thread.currentThread().getName();
    }

}

public class CountDownLatchExp {

    public static void main(String args[]) throws InterruptedException {

        ExecutorService exeService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CountDownLatch latch = new CountDownLatch(3);
        exeService.submit(new Task1(latch));
        exeService.submit(new Task1(latch));
        exeService.submit(new Task1(latch));
        latch.await();

        exeService.shutdown();



    }
}
