package com.company;

import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        //what is this
        ExecutorService executor = Executors.newCachedThreadPool();
        //

        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int delay = random.nextInt(10000);

                System.out.println("Start...");

                try {
                    Thread.sleep(delay);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("...finish");

                return delay;
            }
        });
        executor.shutdown();

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}



