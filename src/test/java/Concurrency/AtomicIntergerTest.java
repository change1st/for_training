package Concurrency;


import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mr_change on 16-8-8.
 */
public class AtomicIntergerTest {

    @Test
    public void testAllMethod() throws InterruptedException {
        final AtomicInteger value = new AtomicInteger(10);
        Assert.assertEquals(value.compareAndSet(1,2), false);
        System.out.println("" + value);

        Assert.assertEquals(value.get(), 10);
        System.out.println("" + value);

        Assert.assertTrue(value.compareAndSet(10, 3));
        System.out.println("" + value);

        Assert.assertEquals(value.get(), 3);

        value.set(0);
        System.out.println("" + value);

        Assert.assertEquals(value.incrementAndGet(), 1);
        System.out.println("" + value);

        Assert.assertEquals(value.getAndAdd(2), 1);
        System.out.println("" + value);

        Assert.assertEquals(value.getAndSet(5), 3);
        System.out.println("" + value);

        final int tSize = 10;
        Thread[] ts = new Thread[tSize];
        for(int start=0;start < tSize;start++) {
            ts[start] = new Thread() {
                public void run() {
                    value.incrementAndGet();
                }
            };
        }

        for(Thread thread : ts) {
            thread.start();
        }

        for(Thread thread : ts) {
            thread.join();
        }

        Assert.assertEquals(value.get(), 5 + tSize);
        System.out.println(value.get());
    }

}
