package lecture.intermidate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Application3 {
    /*
    * sorted(Compartor<>())
    * 스트림에 담긴 데이터들을 정렬해서 반환
    * */

    public static void main(String[] args) {
        List<Integer> integerList = IntStream.of(5,10,99,2,4,6)
                .boxed() // 각 정수를 Integer형태로 변환
//                .sorted()
                .sorted(Comparator.reverseOrder())
                .toList(); //리스트로 변환
    }
}
