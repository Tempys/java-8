package lesson1;

import java.util.stream.LongStream;

/**
 * 2.16 Matching
 */
public class Task16 {

    public static void main(String[] args) {
        boolean result = LongStream
                .rangeClosed(1, 100_000)
                .anyMatch(val -> val == 100_000);
    }
}
