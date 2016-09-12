package com.th.thread;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by mr_change on 16-6-1.
 */
public class ThreadPoolTest {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        List<PlusTask> plusTasks = Lists.newArrayList();
        Random random = new Random();
        for (int count = 0; count < 10; count++) {
            plusTasks.add(new PlusTask(random.nextInt(10) + 1));
        }

        List<Future<Integer>> futures = executorService.invokeAll(plusTasks);
        for (Future<Integer> future : futures) {
            try {
                System.out.println(future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    static class PlusTask implements Callable<Integer> {

        private int base;

        public PlusTask(int base) {
            this.base = base;
        }

        @Override
        public Integer call() throws Exception {
            for (int start = base * 1000; start >= 0; start--) {
                base++;
                Thread.sleep(1);
            }
            return base;
        }
    }
}
