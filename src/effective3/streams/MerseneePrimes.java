package effective3.streams;

import java.math.BigInteger;
import java.util.Objects;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

public class MerseneePrimes {


    private static final BigInteger TWO = valueOf(2);

    public static void main(String[] args) {

        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
              //  .parallel()
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }


    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
