package lesson1;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class IntStreamTest {

    public static void main(String[] args) {
        IntStream.range(0,1_000_000).boxed().collect(toList());


    }
}
