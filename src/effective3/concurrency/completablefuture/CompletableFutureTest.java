package effective3.concurrency.completablefuture;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;



/*
 * Let's say we want to fetch the user's profile from one API call,
 * and the user's friends from another API call, in parallel.
 */
public class CompletableFutureTest {

    // I/0 operations: blocking, synchronous
    String sendHttpGet(String url) { return url; }

    // the business logic: manual, explicit concurrency
    // accepting the executor as a parameter, so that it can be shared
    String runBusinessProcess(ExecutorService executor, long userId) throws InterruptedException {
        // the atomic references will store the results of both API calls
        AtomicReference<String> profileResult = new AtomicReference<String>(null);
        AtomicReference<String> friendsResult = new AtomicReference<String>(null);
        // the latch will reach 0 once both API calls complete
        CountDownLatch done = new CountDownLatch(2);

        // submitting tasks to send the API calls. If the executor has enough threads,
        // these will run in parallel
        executor.execute(() -> {
            String result = sendHttpGet("http://profile_service/get/" + userId);
            profileResult.set(result);
            done.countDown();
        });
        executor.execute(() -> {
            String result = sendHttpGet("http://friends_service/get/" + userId);
            friendsResult.set(result);
            done.countDown();
        });

        // in the main thread, waiting until both computations are done
        done.await();

        return "Profile: " + profileResult.get() + ", friends: " + friendsResult.get();
    }

    String  runBusinessProcess(final long userId) throws ExecutionException, InterruptedException {

        java.util.concurrent.CompletableFuture profile = java.util.concurrent.CompletableFuture.supplyAsync(() -> sendHttpGet("http://profile_service/get/" + userId));
        java.util.concurrent.CompletableFuture friends = java.util.concurrent.CompletableFuture.supplyAsync(() -> sendHttpGet("http://friends_service/get/" + userId));

        return (String) profile.thenCombine(friends,(a,b) -> "Profile: " + a + ", friends: " + b).get();
    }


    String  runBusinessProcessWithCompose(final long userId) throws ExecutionException, InterruptedException {

        java.util.concurrent.CompletableFuture profileResult = java.util.concurrent.CompletableFuture.supplyAsync(() -> sendHttpGet("http://profile_service/get/" + userId));
        java.util.concurrent.CompletableFuture friendsResult = java.util.concurrent.CompletableFuture.supplyAsync(() -> sendHttpGet("http://friends_service/get/" + userId));

        //return (String) profile.thenCombine(friends,(a,b) -> "Profile: " + a + ", friends: " + b).get();

        return (String) profileResult.thenCompose(profile -> friendsResult.thenApply(friends -> "Profile: " + profile + ", friends: " + friends )).get();
    }

    void runBusinessProcessWithConbinations(List<Long> ids){

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(new CompletableFutureTest().runBusinessProcess(2));
        System.out.println(new CompletableFutureTest().runBusinessProcessWithCompose(2));
    }


}
