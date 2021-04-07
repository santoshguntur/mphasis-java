package com.mph;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//usage of cachedthreadpool to execute the task in run method
class RunClas implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}

public class CachedExample {
    public static void main(String[] args) {

        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println(coreCount);
        ExecutorService service = Executors.newCachedThreadPool();
        //if corecount is hardcoded , it vl create the threads
        // and scheduler decides which one to execute
        for (int counter = 0; counter < 10; counter++) {
            service.execute(new RunClas());
        }
        service.shutdown();
    }

}
