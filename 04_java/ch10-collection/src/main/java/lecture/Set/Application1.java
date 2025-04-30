package lecture.Set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {
        /*
        * Set 인터페이스 구현
        * - 요소의 저장 순서를 유지하지 않음
        * - 같은 요소의 중복 저장을 허용하지 않음 (null값도 중복 x) */

        HashSet<String> hset = new HashSet<>();
        Set<String> set = new HashSet<>();

        hset.add("java");
        hset.add("mysql");
        hset.add("jdbc");
        hset.add("html");
        hset.add("css");

        // 저장 순서 유지 X
        System.out.println("hset : " + hset);
        hset.add("java");

        System.out.println("hset : "+ hset);
        System.out.println("저장된 객체 수 : "+ hset.size());

        System.out.println("포함확인 : " + hset.contains("oracle"));
        System.out.println("포함확인 : " + hset.contains("java"));

        for(String str: hset){
            System.out.println(str);
        }

        // toArrary(). : 배열로 바꾸고 for 문 사용 가능
        Object[] arr = hset.toArray();

        for (int i=0; i < arr.length; i++){
            System.out.println(i + " : " + arr[i]);
        }

        hset.remove("java");
        System.out.println("hset :" + hset);

        hset.clear();
        System.out.println("hset : " + hset);
        System.out.println("hset isEmpty? :" + hset.isEmpty());



    }
}
