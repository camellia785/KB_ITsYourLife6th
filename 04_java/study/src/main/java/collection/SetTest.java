package main.java.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        String s = "bbbaaacdddefecge";
        // a b c d e f g
        // s에 들어있는 문자를 하나씩 꺼내서 hashset에 넣기
        // 중복제거됨

        Set<String> set = new HashSet<>();
        String[] s2 = s.split("");
        // {"b", "b", "b", "a" ~ }
        // 배열로 정렬 먼저 하면 편하겠다.

        Arrays.sort(s2);
        for(String x: s2){
            set.add(x); // 중복되는 것은 넣지 않음
        }
        // {"a", "b", "c", ~~ }
        System.out.println(set); // 패키지, 클래스명@해시코드
        // toString() 메서드가 재정의 --> set에 있는 목록을 문자열로 만들어주는 것

        // set을 하나씩 꺼낼때 사용하는 방법 2가지
        // for-each 문(반복자가 만들어져서 동작하는 개념)
        for(String x2 : set){
            System.out.println(x2 + " ");
        }
        System.out.println("-----------------------");
        // 반복자를 외부에 만들어주자.

    }
}
