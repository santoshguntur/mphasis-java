package com.mph;
import java.util.concurrent.*;

//implemetation of phaser
class PointClass{
    int x,y;

    public PointClass(int x, int y) {
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

class TaskClass implements Runnable{

    Phaser phaser;

    public TaskClass(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run()  {
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndDeregister();

        System.out.println("Progress...");
    }
}
public class PhaserExample {
    public static void main(String[] args) throws InterruptedException {

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        Phaser phaser = new Phaser(3);

        service.submit(new TaskClass(phaser));
        service.submit(new TaskClass(phaser));
        service.submit(new TaskClass(phaser));

              phaser.arriveAndAwaitAdvance(); //main thread is blocked

        System.out.println("initiating shutdown");
        service.shutdown();
        System.out.println("shutdown initiated");

    }

}




