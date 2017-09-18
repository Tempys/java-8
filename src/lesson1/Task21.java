package lesson1;

import java.util.stream.LongStream;

/**
 * Write a method for calculating the sum of odd numbers in the given interval (inclusively) using Stream API.

 Important. Use the provided template for your method. Pay attention to type of an argument and the returned value. Please, don't use cycles.

 Sample Input 1:
 0 0
 Sample Output 1:
 0
 Sample Input 2:
 7 9
 Sample Output 2:
 16
 Sample Input 3:
 21 30
 Sample Output 3:
 125
 */
public class Task21 {
    public static long sumOfOddNumbersInRange(long start, long end) {
        // write your code here
        if (start == 0) return 0;
         return LongStream.range(start,end+1).filter(i -> i %2 !=0 ).sum();
    }

    public static void main(String[] args) {
      //  System.out.println(sumOfOddNumbersInRange(7,9));
        System.out.println(sumOfOddNumbersInRange(21,30));
    }
}
