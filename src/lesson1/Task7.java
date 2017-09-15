package lesson1;

import java.util.function.Function;

/**
 * Using closure write a lambda expression that adds prefix (before) and suffix (after) to its single string argument; prefix and suffix are final variables and will be available in the context during testing.

 All whitespaces on the both ends of the argument must be removed. Do not trim prefix, suffix and the result string.

 Solution format. Submit your lambda expression in any valid format with ; on the end.

 Examples: (x, y) -> x + y; (x, y) -> { return x + y; }
 */
public class Task7 {


    public static void main(String[] args) {
       String prefix ="";
       String suffix ="";
       Function<String,String> result = (x) -> prefix+x.trim()+suffix;
    }
}
