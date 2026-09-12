package AtomicVariable;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    public static AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        while (true) {
            int curr = count.get();

            if (count.compareAndSet(curr, curr + 1)) {
                System.out.println(
                        Thread.currentThread().getName() +
                                " incremented count to: " + count.get()
                );
                return;
            }
        }
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        Thread t1 = new Thread(c::increment);
        Thread t2 = new Thread(c::increment);
        Thread t3 = new Thread(c::increment);
        t1.start();
        t2.start();
        t3.start();
    }

}
