package effective3.concurrency.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Compare3aWrappers {
    // data structures
    class RSS {
        String getFeedAddress() { return null; }
    }

    // I/O operations: non-blocking, asynchronous
    <T> CompletableFuture<T> fetchFromDb(Class<T> entityClass, long id) { return null; }
    CompletableFuture<String> sendHttpGet(String url) { return null; }

    // the business logic: asynchronous
    CompletableFuture<List<String>> fetchRssContent(List<Long> rssIds)
            throws InterruptedException {

        List<CompletableFuture<String>> listOfFutureContents =
                rssIds.stream()
                        // all I/O db operations will run concurrently
                        .map(rssId -> fetchFromDb(RSS.class, rssId))
                        // after each db operation is complete,
                        // scheduling the http send
                        .map(futureRss -> futureRss.thenCompose(rss ->
                                sendHttpGet(rss.getFeedAddress())))
                        .collect(Collectors.toList());

        // combining a list of futures into a future of a list
        return CompletableFuture.allOf(listOfFutureContents.toArray(
                new CompletableFuture[0]))
                .thenApply(v -> listOfFutureContents.stream()
                        // we are now certain all futures are done
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));
    }

}
