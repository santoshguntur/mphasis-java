package com.company.thread;


import java.util.concurrent.*;
import java.util.logging.Logger;

public class fixedthread {

    public static void main(String args[]) {
       int core= Runtime.getRuntime().availableProcessors();
    //    ExecutorService pool = Executors.newFixedThreadPool(core);
           // ExecutorService pool = Executors.newCachedThreadPool();
        ScheduledExecutorService s=Executors.newScheduledThreadPool(core);

     //   for(int i=0;i<10;i++)
        /*s.schedule((() ->{ System.out.println(Thread.currentThread());
                    Logger log=Logger.getLogger(Thread.currentThread().getName());
                    log.info("Task1");
                }),
                5,
                TimeUnit.SECONDS);*/
        s.scheduleAtFixedRate((() ->{ System.out.println(Thread.currentThread());
                    Logger log=Logger.getLogger(Thread.currentThread().getName());
                    log.info("Task1");
                }),
                5,10,
                TimeUnit.SECONDS);
        //s.shutdown();
    }
}
