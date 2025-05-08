package basic.ch17.sec10;

import java.util.Arrays;

public class AggregateExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        //2의 배수 카운팅
        long count = Arrays.stream(arr)
                .filter(n -> (n%2 ==0))
                .count();
        System.out.println("count: " + count);

        //2의 배수 총합
        long sum = Arrays.stream(arr)
                .filter(n -> (n%2 ==0))
                .sum();
        System.out.println( "sum: " + sum);

        //2의 배수 평균
        double avg = Arrays.stream(arr)
                .filter(n -> (n%2 ==0))
                .average() // OptionalDouble 반환 (평균최대최소)
                 .getAsDouble(); // 실수평균반환
        System.out.println("average: " + avg);

        //2의 배수 중 최대값
        int max = Arrays.stream(arr)
                .filter(n -> (n%2 ==0))
                .max() // OptionalInt 반환
                .getAsInt();
        System.out.println("max: " + max );

        //2의 배수 중 최소값
        int min = Arrays.stream(arr)
                .filter(n -> (n%2 ==0))
                .min() // OptionalInt 반환
                .getAsInt();
        System.out.println("min: " + min );

        //첫 번째 3의 배수
        int first = Arrays.stream(arr)
                .filter(n->n%3==0)
                .findFirst()
                .getAsInt();
        System.out.println("first: " + first);
    }
}
