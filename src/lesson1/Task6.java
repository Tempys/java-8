package lesson1;

import java.util.function.Function;


/**
 * Using closure write a lambda expression that calculates a∗x2+b∗x+ca∗x2+b∗x+c where a, b, c are context final variables. They will be available in the context during testing. Note, the result is double.

 Solution format. Submit your lambda expression in any valid format with ; on the end.

 Examples: (x, y) -> x + y; (x, y) -> { return x + y; }
 */
public class Task6 {
    final int a =1;
    final  int b =1;
    final  int c =1;
  final  Function<Integer,Integer> action = (x) -> a*x*x+b*x+c;

    public static void main(String[] args) {

        System.out.println(new Task6().action.apply(5));

        System.out.println(5^2);
    }
}
