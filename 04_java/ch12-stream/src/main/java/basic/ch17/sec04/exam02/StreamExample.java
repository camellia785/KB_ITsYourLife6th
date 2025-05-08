package basic.ch17.sec04.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // Arrays.stream(arr) -> 이런식으로 문자열 스트림 생성
        String[] strArray = { "홍길동", "신용권", "김미나"}; // 문자열 배열
        Stream<String> strStream = Arrays.stream(strArray); //문자열 스트림 생성
        strStream.forEach(item-> System.out.println(item+" ")); // 각 문자열 출력

        int[] intArray = { 1, 2, 3, 4, 5 }; // 정수 배열
        IntStream intStream = Arrays.stream(intArray); // 정수 스트림 생성
        intStream.forEach(item-> System.out.println(item + "")); // 각 숫자 출력
    }
}
