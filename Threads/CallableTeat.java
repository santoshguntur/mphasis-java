package com.company.thread;

import java.util.concurrent.*;

class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}

public class CallableTeat {
    
    public   static void main(String[] args) {
        ExecutorService exe= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Integer> returnValue = exe.submit(new Task());

        try {
            Integer value = returnValue.get();
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
