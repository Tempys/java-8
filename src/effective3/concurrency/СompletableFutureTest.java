package effective3.concurrency;

import java.util.concurrent.*;

public class СompletableFutureTest {


    public static Integer
    getValue() {
        System.out.println("I am called");

        // Simulating a long network call of 1 second in the worst case
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 10;
    }

    public static void main() {
        ExecutorService executor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                // This is an unbounded Queue. This should never be used
                // in real life. That is the first step to failure.
                new LinkedBlockingQueue<Runnable>());


}


}