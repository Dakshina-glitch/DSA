package rentrantLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Cache {

    private final Map<String, String> cache = new HashMap<>();

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void get(String key) {
        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " started reading");
            System.out.println(cache.getOrDefault(key, "No data found in cache"));
            Thread.sleep(3000);

            System.out.println(Thread.currentThread().getName() + " finished reading");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void put(String key, String value) {
        lock.writeLock().lock();

        try {
            cache.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Cache ch = new Cache();
        Thread t1 = new Thread(() -> ch.put("1", "abc"));
        Thread t2 = new Thread(() -> ch.get("1"));
        Thread t3 = new Thread(() -> ch.get("2"));
        Thread t4 = new Thread(() -> ch.get("1"));
        Thread t5 = new Thread(() -> ch.put("1", "xyz"));
        Thread t6 = new Thread(() -> ch.get("1"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
     //   t5.join();
        t6.start();
    }
}