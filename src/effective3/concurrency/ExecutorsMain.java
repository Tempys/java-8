package effective3.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsMain
{

    public static void main(String[] args) {
        ExecutorService exec =  Executors.newCachedThreadPool();
    }
}
