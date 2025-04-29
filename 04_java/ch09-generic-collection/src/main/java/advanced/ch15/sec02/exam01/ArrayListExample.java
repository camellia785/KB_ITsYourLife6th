package advanced.ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // 1. ArrayList 인스턴스 생성
        List<Board> list = new ArrayList<>();

        // 2. Board 인스턴스 5개 생성 후 추가
        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));

        // 3. 요소 개수 출력
        System.out.println("총 객체 수: " + list.size());

        // 4. 3번째 데이터 추출 (index 2)
        System.out.println("3번째 데이터: " + list.get(2));

        // 5. 일반 for문으로 순회
        System.out.println("\n--- 일반 for문 출력 ---");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // 6. 인덱스 2 요소 제거
        list.remove(2); // "제목3" 제거
        list.remove(2); // "제목4" 제거됨 (앞이 하나 없어져서 밀림)

        // 7. 향상된 for 문으로 출력
        System.out.println("\n--- 향상된 for문 출력 ---");
        for (Board board : list) {
            System.out.println(board);
        }
    }
}
