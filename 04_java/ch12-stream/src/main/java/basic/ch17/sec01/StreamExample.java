package basic.ch17.sec01;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {
    /*
    * 스트림 : 컬렉션, 배열같이 자바에서 데이터 소스를 편하게 다루기 위한 문법
    *
    * 스트림 구조
    * 스트림객체 -> 중간연산 -> 최종연산
    *
    * 스트림 특징
    * 1. 원본 데이터를 변경시키지 않는다.
    * 2. 일회용이기때문에 최종 연산 이후에는 다시 스트림을 생성해야한다.
    * 3. 작업을 내부적으로 반복처리한다.
    * 4. 병렬처리가 가능하다.
    * */

    public static void main(String[] args) {
        Set<String> set = new HashSet< >();
        set.add("홍길동");
        set.add("신용권");
        set.add("감자바");

        System.out.println("-------향상된 for문 사용 ------------");
        for(String str : set){
            System.out.println(str);
        }

        System.out.println("------- Stream 사용 ------------");
        Stream<String> stream = set.stream();

        stream.forEach(name -> System.out.println(name));
        set.forEach(name -> System.out.println(name));

        System.out.println("------- Stream 2 사용 ------------");
        set.stream()
                // 사전순 정렬
                .sorted(Comparator.reverseOrder())
                // 앞에서부터 크기만큼 자르기
                .limit(2)
                .forEach(name-> System.out.println(name));
    }
}
