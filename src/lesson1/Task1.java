package lesson1;

import java.util.function.BiFunction;


/**
 * Write a lambda expression that accepts two integers arguments and returns max of them.

 Try not to use the Math library.

 Solution format. Submit your lambda expression in any valid format with ; on the end.

 Examples: (x, y) -> x + y; (x) -> { return x; };
 */
public class Task1 {

   static BiFunction<Integer,Integer,Integer> max =(x,y) -> (x > y ) ? x : y;


    public static void main(String[] args) {
        System.out.println(  max.apply(5,4));
    }
}
