package lecture.list;

import java.time.LocalDateTime;
import java.util.*;

public class Application1 {
    public static void main(String[] args) {

        /*
        * 컬렉션 프레임워크는 크게 3가지 인터페이스 중 한가지를 상속받아 구현
        * List 인터페이스 -> 순서존재, 중복허용, vector & ArraryList & LinkedList & Stack & Queue
        * Set 인터페이스 -> 순서없음, 중복비허용, HashSet & TreeSet
        * Map 인터페이스 -> key-value쌍으로 이루어진 데이터 집합 (순서X, 중복된 키 불가), HashMap& TreeMap & HashTable & Properties
        * */

        // 가변적이고 요소의 추가수정삭제를 메소드로 제공해줌
        ArrayList<Object> alist = new ArrayList<>();
        List<Object> list = new ArrayList<>();

        list.add("apple");
        list.add(123);
        list.add(45.64);
        list.add(LocalDateTime.now());

        System.out.println(list); // toString() 오버라이딩되어 있음.
        System.out.println("list의 크기 : " + list.size()); // 안에 있는 요소의 개수 반환

        list.add(1, "banana");
        System.out.println(list);

        list.set(1,"true"); // set으로 값 바꾸기
        System.out.println(list);

        list.remove(1); // remove로 값 지우기
        System.out.println(list);

        /*
        * LinkedList
        * - 연속되게 저장되어 있지 않고, 요소와 요소를 앞뒤에 있는 것들만 기억하게끔 구현되어 있음
        * - 저장한 요소가 순서를 유지하지 않고 저장됨
        * - 요소들 사이를 링크로 연결하여 구성해, 마치 연결된 리스트처럼 만듦
        * - 저장과 삭제가 빈번하게 일어나는 경우에 적합*/
        List<String> strList = new LinkedList<>();

        strList.add("a");
        strList.add("c");
        strList.add("b");
        strList.add("d");
        System.out.println(strList);

        Collections.sort(strList);
        System.out.println(strList);

        Collections.reverse(strList);
        System.out.println(strList);

        /*
        * Iterator(반복자)
        * -> Collection 인터페이스의 iterator()메소드를 이용해서 생성가능
        * -> 컬렉션에서 값을 읽어오는 방식을 통일된 방식으로 제공하기 위해 사용
        * */

        Iterator<String> iterator = strList.iterator(); // Iterator 객체 생성

        /*
        * hasNext() : 다음요소가 남아있으면 true, 없으면 false
        * next() : 커서를 현재 요소의 다음요소로 이동시키고 그 요소를 반환
        * */
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
        }



    }
}
