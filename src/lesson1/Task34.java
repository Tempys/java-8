package lesson1;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * Write three functions:

 Multifunctional mapper (transformer) that accepts a list of operators (mappers) and returns a new operator. The returned operator accepts a list of integer numbers and sequentially applies each mapper to each number in the list (performs multiple transformations). The result is a list with transformed values.
 In terms of the multifunctional mapper define an operator that multiplies by two each integer number and then add one to its. The operator is applied to each number in the input list.
 In terms of the multifunctional mapper define an operator that squares each integer number and then calculates the next even number following it. The operator is also applied to each number in the input list.
 To simplify the problem all function (represented by objects) are declared, you need to finish their realization.
 Look carefully at definition of each function.

 Also there is an example: identity operation that is defined in terms of the multifunctional mapper. It doesn't changes values in the input list. It repeats identity transformation three times just for example.

 During testing all operators will be tested (including identity).

 Example 1. An input list with integer numbers [1, 1, 1, 1].
 identityTransformation returns the result list [1, 1, 1, 1].
 multTwoAndThenAddOneTransformation returns the result list [3, 3, 3, 3].
 squareAndThenGetNextEvenNumberTransformation returns the result list [2, 2, 2, 2].
 Example 2. An input list with integer numbers [1, 2, 3].
 identityTransformation returns the result list [1, 2, 3].
 multTwoAndThenAddOneTransformation returns the result list [3, 5, 7].
 squareAndThenGetNextEvenNumberTransformation returns the result list [2, 6, 10].
 ﻿If the task is too hard for you, see theory lesson on currying, URL: https://stepik.org/lesson/Returning-functions-and-currying-35160/step/1?course=Java-Functional-progr...﻿
 */
public class Task34 {

    public static void main(String[] args) {
        System.out.println( multTwoAndThenAddOneTransformation.apply(Arrays.asList(1, 1, 1)));
        System.out.println( multTwoAndThenAddOneTransformation.apply(Arrays.asList(1, 2, 3)));

        System.out.println( squareAndThenGetNextEvenNumberTransformation.apply(Arrays.asList(1, 1, 1)));
        System.out.println( squareAndThenGetNextEvenNumberTransformation.apply(Arrays.asList(1, 2, 3)));
    }

    /**
     * The function accepts a list of mappers and returns an operator that accepts a list of integers
     * and sequentially applies each mapper to each value (perform a transformation)
     */
    public static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> multifunctionalMapper1 = x -> y -> y.stream().map(integer ->{

        int result = integer;

        for(IntUnaryOperator operator : x){
             result= operator.applyAsInt(result);
      }

      return result;
    }).collect(Collectors.toList()) ;


    public static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> multifunctionalMapper = x -> y -> y.stream().map( integer -> x.stream().reduce(IntUnaryOperator::andThen).orElse(other -> other).applyAsInt(integer)).collect(Collectors.toList());
    /**
     * EXAMPLE: the operator transforms each number to the same number (perform the identity transformation)
     *
     * It returns a list of the same numbers.
     */
    public static final UnaryOperator<List<Integer>> identityTransformation = multifunctionalMapper.apply(Arrays.asList(x -> x, x -> x, x -> x));

    /**
     * The operator accepts an integer list.
     * It multiplies by two each integer number and then add one to its.
     *
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> multTwoAndThenAddOneTransformation = multifunctionalMapper.apply(Arrays.asList(x -> x*2,x -> x+1));

    /**
     * The operator accepts an integer list.
     * It squares each integer number and then get the next even number following it.
     *
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> squareAndThenGetNextEvenNumberTransformation = multifunctionalMapper.apply(Arrays.asList(x -> x*x, x -> ++x % 2 == 0 ? x : ++x));


}
