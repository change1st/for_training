package thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by mr_change on 16-6-1.
 */
public class ThreadDaemon {

    private static Logger logger = LoggerFactory.getLogger(ThreadDaemon.class);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Thread thread = new Thread(new DaemonRunner(), "daemaonRunner");
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(3);
    }

    static class DaemonRunner implements Runnable {

        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                logger.error("sleep error");
            } finally {
                System.out.println("finally");
            }
        }
    }
}
