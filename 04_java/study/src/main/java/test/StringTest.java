package main.java.test;

public class StringTest {
    public static void main(String[] args) {
        String s0 = null;
        //힙영역에 값을 넣지는 않음. 주소없음 의미
        System.out.println(s0);

        String s1 = "자바";
        // 한줄복사 command+D
        String s2 = "자바";

        //주소 동일한지 체크
        System.out.println(s1==s2);
        //참조형은 ==은 주소 비교

        String s3 = new String("자바");
        System.out.println(s1 == s3);

        //String타입 변수(주소)가 가르키는 값이 동일한지 체크
        System.out.println(s1.equals(s3));

    }
}
