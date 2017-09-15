package lesson1;

import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;

/**
 * You have the following part of a code:

     IntUnaryOperator mult2 = num -> num * 2;
     IntUnaryOperator add3 = num -> num + 3;

    IntUnaryOperator combinedOperator = add3.compose(mult2.andThen(add3)).andThen(mult2);
    int result = combinedOperator.applyAsInt(5);
    The result is ...
 */
public class Task11 {

    public static void main(String[] args) {
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> devNull = (val) -> { int v = val * 2; };

        Consumer<Integer> combinedConsumer = devNull.andThen(devNull.andThen(printer));
        combinedConsumer.accept(100);
    }
}
