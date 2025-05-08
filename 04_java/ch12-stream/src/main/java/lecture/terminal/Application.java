package lecture.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        /*
        * Calculating
        * -> 최대/최소.종합/평균과 같은 결고
        * */


        long count = IntStream.range(1,10).count();
        long sum = IntStream.range(1,10).sum();

        System.out.println("count/" + count);
        System.out.println("sum" + sum);

        // max min
        OptionalInt max = IntStream.range(1,20).max();

    }
}
