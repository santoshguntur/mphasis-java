package com.mph;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//implementation of execute method in Executor Interface
class RunClass implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread());

    }
}

public class ExecutorExample {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println(coreCount);
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        for (int counter = 0; counter < 10; counter++) {
            service.execute(new RunClass());
        }
        service.shutdown();
    }
}
