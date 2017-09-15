package lesson1;

import java.util.function.LongFunction;


/**
 * Write a lambda expression that accepts a long value and returns a next even number.

 It is guaranteed an input number is non-negative.

 Solution format. Submit your lambda expression in any valid format with ; on the end.

 Examples: x -> x; (x) -> x; (x) -> { return x; };

 Sample Input 1:
 2
 Sample Output 1:
 4
 Sample Input 2:
 317
 Sample Output 2:
 318
 */
public class Task2 {


    static   LongFunction<Long> iter1 = x -> x % 2 == 0 ? x + 2 : x + 1;

    public static void main(String[] args) {
        System.out.println(iter1.apply(8));
    }
}
