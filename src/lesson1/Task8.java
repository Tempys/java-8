package lesson1;

import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task8 {


    Callable<String> callable = ()-> "hello";
    final double variable = 10.0;
   // Serializable serializable = (x) ->  variable + x ;


    public static void main(String[] args) {


      IntStream a = IntStream.range(1,1000);
        IntStream a1 = IntStream.range(1,1000);


    ///    Stream.of(a,a1).flatMapToInt()
    }
}
