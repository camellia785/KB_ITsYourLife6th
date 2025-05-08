package lecture.terminal;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application2 {

    /*
     * reduce: 스트림에 잇는 데이터들의 총합계산*/

    public static void main(String[] args) {
        OptionalInt reduceOneParam = IntStream.range(1, 4)
                .reduce((a, b) -> {
                    return Integer.sum(a, b);
                });

    }
}
