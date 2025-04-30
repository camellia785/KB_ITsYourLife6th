package lecture.list;

import java.util.LinkedList;
import java.util.Queue;

public class Application3 {
    public static void main(String[] args) {
        /*
        * Queue
        * - 선형 메모리 공간에 데이터를 저장하는 선입선출(FIFO) 방식의 자료구조
        * - 자체가 인터페이스이기 때문에 인스턴스 생성 불가
        * */

        Queue<String> a_que = new LinkedList<>();

        // offer() : Queue에 데이터를 넣는 함수
        a_que.offer("first");
        a_que.offer("second");
        a_que.offer("third");
        a_que.offer("fourth");
        a_que.offer("fifth");
        System.out.println("que = " + a_que);

        /*
        * peek() : 해당 큐에 가장 앞에 있는 요소를 반환
        * poll() : 해당 큐에 가장 앞에 있는 요소를 반환 후 제거
        * */

        System.out.println("peek() : "+ a_que.peek());
        System.out.println("que : "+ a_que );

        System.out.println("poll() : "+ a_que.poll());
        System.out.println("que : "+ a_que );

    }
}
