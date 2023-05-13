package com.example.library.multithreads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger counter = new AtomicInteger(0);
        Task task = new Task(counter);
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        long start = System.currentTimeMillis();
        t1.start();
       // t2.start();
        t1.join();
       // t2.join();

        long end = System.currentTimeMillis();

        System.out.println(String.format("Time to process %d, and counter= %d", (end - start), counter.get()));


        NameTask<String> task1 = new NameTask<>();
        FutureTask<String> taskFutureTask = new FutureTask<>(task1);

        Thread t3 = new Thread(taskFutureTask);
        t3.start();

        String name = null;
        try {
            name = taskFutureTask.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("My Name is - "+ name);


        Executor executor = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("test"));
        executorService.execute(() -> System.out.println("test"));
        executorService.shutdown();

    }

    public static class Task implements Runnable {
        private AtomicInteger counter;

        public Task(AtomicInteger counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int k = 0; k < 8000000l; k++) {
                counter.getAndIncrement();
            }
        }
    }


    public static class NameTask<String> implements Callable<java.lang.String>{
        @Override
        public java.lang.String call() throws Exception {
            return "Hello RAM";
        }
    }
}
