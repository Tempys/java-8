package lesson1;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 *Write the disjunctAll method that accepts a list of IntPredicate's and returns a single IntPredicate. The result predicate is a disjunction of all input predicates.

 If the input list is empty then the result predicate should return false for any integer value (always false).

 Important. Pay attention to the provided method template. Do not change it.
 */
public class Task12
{

    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        Optional<IntPredicate> predicate = predicates.stream().filter(i -> i.test(1)).findFirst();

        if (predicate.isPresent())
        {
            return predicate.get();
        }

        IntPredicate fail = i -> {return false;};

        return fail;
    }

    public static IntPredicate rightDisjunctAll(List<IntPredicate> predicates) {
        return predicates.stream()
                         .reduce(IntPredicate::or)
                         .orElse(i -> false);
    }

    public static void main(String[] args) {

    }
}
