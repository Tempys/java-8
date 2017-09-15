package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Task15 {
    private static List<Double> NUMBERS_FOR_AVERAGE = new ArrayList<Double>();

    static  {
        NUMBERS_FOR_AVERAGE.add(new Double(10));
        NUMBERS_FOR_AVERAGE.add(new Double(10));
        NUMBERS_FOR_AVERAGE.add(new Double(10));
        NUMBERS_FOR_AVERAGE.add(new Double(10));
        NUMBERS_FOR_AVERAGE.add(new Double(10));
        NUMBERS_FOR_AVERAGE.add(new Double(10));
        NUMBERS_FOR_AVERAGE.add(new Double(10));
        NUMBERS_FOR_AVERAGE.add(new Double(10));
        NUMBERS_FOR_AVERAGE.add(new Double(10));
        NUMBERS_FOR_AVERAGE.add(new Double(10));
    }


    public static void main(String[] args) {
        Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");

// Get collection without duplicate i.e. distinct only
        List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());



//Let's verify distinct elements
        System.out.println(distinctElements);
        NUMBERS_FOR_AVERAGE.stream().limit(10);


        NUMBERS_FOR_AVERAGE.stream().mapToDouble(a -> a);

            }
}
