package com.mph;

import java.util.concurrent.*;

//Usage of scheduled thread pool
class Points {
    int x, y;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

//Implementation of Callable interface with Future
class Tasks implements Callable<Points> {

    @Override
    public Points call() throws Exception {
        return new Points(2, 6);
    }
}

public class CallableExample {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newScheduledThreadPool(coreCount);
        Future<Points> future = service.submit(new Tasks());
        try {
            Points point = future.get();
            System.out.println(point);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
        service.shutdown();

    }

}
