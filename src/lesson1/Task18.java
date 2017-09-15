package lesson1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create a stream that will detect bad words in a text according to a bad words list. All words in the text are divided by whitespaces (always only one whitespace between two words).

 After calling collect(Collectors.toList()) the stream must return the list of bad words which were found in the text. The result should be dictionary ordered (in lexicographical order, i.e. sorted) and bad words shouldn't repeat.

 Important. You need return a prepared stream from the template method, not a list of bad words. Pay attention to the method template. Do not change it!
 */
public class Task18 {

    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        return  Stream.of(text.split(" ")).filter(badWords::contains).sorted().distinct();// write your stream here
    }
}
