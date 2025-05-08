package lecture.intermidate;

import java.util.stream.IntStream;

public class Application2 {
    /*
    * MAP: 스트킴에 들어있는 데이터를 특정 람다식을 통해 각각의 데이터를 가공
    *       새로운 스르림에 담아준다*/

    public static void main(String[] args) {
        IntStream intStream = IntStream.range(0,10);

        intStream.filter(i->(i%2)==0) // 2,4,6,8
                .map(i->i*5) //각 5곱해서 새로운 스트림에 담음
                .forEach(i-> System.out.println(i+" "));

    }
}
