import java.math.BigInteger;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
//         ((((3 * 10) + 1) + 3) * 2 => 68
        Function<Integer, Integer> multiplyTen = a -> a * 10;
        Function<Integer, Integer> addOne = a -> a + 1;
        Function<Integer, Integer> addThree = a -> a + 3;
        Function<Integer, Integer> multiplyTwo = a -> a * 2;
        System.out.println(multiplyTen.andThen(addOne).andThen(addThree).andThen(multiplyTwo).apply(3));

//        n!
        System.out.println(factorial(5));



    }
    private static long factorial(long n) {
        Function<Long, Long> factorial = x -> (x == 0) ? 1 : x * factorial(x-1);
        return factorial.apply(n);
    }
}