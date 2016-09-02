package Concurrency;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by mr_change on 16-8-8.
 */
public class AtomicInterArrayTest {

    class DemoData {
        public volatile int value1 = 1;
        volatile int value2 = 2;
        protected volatile int value3 = 3;
        private volatile int value4 = 4;

        @Override
        public String toString() {
            return "value1:" + value1 + "value2:" + value2 + "value3:" + value3 + "value4:" + value4;
        }
    }

    AtomicIntegerFieldUpdater<DemoData> getUpdater(String fn) {
        return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fn);
    }

    void doIt() {
        DemoData demoData = new DemoData();
        System.out.println(demoData.toString());
        System.out.println("1==>" + getUpdater("value1").getAndSet(demoData, 10));
        System.out.println("2==>" + getUpdater("value2").incrementAndGet(demoData));
//        System.out.println("3==>" + getUpdater("value3").decrementAndGet(demoData));
//        System.out.println("4==>" + getUpdater("value4").compareAndSet(demoData, 4, 5));
        System.out.println(demoData.toString());
    }

    @Test
    public void testAtomicInterArray() {
        AtomicInterArrayTest test = new AtomicInterArrayTest();
        test.doIt();
    }
}
