package thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by mr_change on 16-6-1.
 */
public class ThreadPoolRealTime {

    private static final ExecutorService plusExecutorService = Executors.newFixedThreadPool(5);

    private static final ExecutorService outPutExecutorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Random random = new Random();
        for(int count = 0;count < 10;count++) {
            Future<Integer> future = plusExecutorService.submit(new PlusTask(random.nextInt(10) + 1));
            outPutExecutorService.execute(new OutPutTask(future));
        }

    }

    static class PlusTask implements Callable<Integer> {

        private int base;

        public PlusTask(int base) {
            this.base = base;
        }

        @Override
        public Integer call() throws Exception {
            for (int start = base*1000; start >= 0; start--) {
                base++;
                Thread.sleep(1);
            }
            return base;
        }
    }

    static class OutPutTask implements Runnable {
        private Future<Integer> future;

        public OutPutTask(Future<Integer> future) {
            this.future = future;
        }

        @Override
        public void run() {
            boolean flag = true;
            while (flag) {
                try {
                    if (future.isDone()) {
                        flag = false;
                        System.out.println(future.get());
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
