package lesson1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class OptionalTask {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,3,1,2,4,2,3,2,3,4,3,2,5,4,3,5,3,4,5,3,4,2,5,3,5,3,4,5,3,4};

       Map<Integer,Long> result =  Arrays.asList(a).stream().collect(Collectors.groupingBy(i-> i,Collectors.counting()));

     long max =  result.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

      int key =  result.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);;


        System.out.println(result);
        System.out.println(max);
        System.out.println(key);
    }
}
