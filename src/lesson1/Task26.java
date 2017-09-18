package lesson1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a collector that evaluates the product of squares of integer numbers in a Stream<Integer>.

 Important. You should write only the collector in any valid formats but without ; on the end.
 It will be passed as an argument to the collect() method of a stream as shown below.

 List<Integer> numbers = ...
 long val = numbers.stream().collect(...your_collector_will_be_passed_here...);

 Examples of the valid solution formats: Collectors.reducing(...) or reducing(...).
 Sample Input 1:
 0 1 2 3
 Sample Output 1:
 0
 Sample Input 2:
 1 2
 Sample Output 2:
 4
 */
public class Task26 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2);
        //List<Integer> numbers =

        long val = Arrays.asList(1,2).stream().collect(Collectors.reducing(1,(i,j)-> i * j*j ));
        long val1 = Stream.of(0, 1, 2, 3).collect(Collectors.reducing(1,(i, j)-> i * j*j ));
        System.out.println(val1);
    }

}
