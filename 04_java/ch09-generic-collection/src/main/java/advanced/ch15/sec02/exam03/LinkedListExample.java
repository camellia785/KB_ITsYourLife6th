package advanced.ch15.sec02.exam03;

import advanced.ch15.sec02.exam01.Board;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        // ArrayList → LinkedList로 변경
        List<Board> list = new LinkedList<>();

        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));

        System.out.println("총 객체 수: " + list.size());
        System.out.println("3번째 데이터: " + list.get(2));

        System.out.println("\n--- 일반 for문 출력 ---");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(2);
        list.remove(2);

        System.out.println("\n--- 향상된 for문 출력 ---");
        for (Board board : list) {
            System.out.println(board);
        }
    }
}
