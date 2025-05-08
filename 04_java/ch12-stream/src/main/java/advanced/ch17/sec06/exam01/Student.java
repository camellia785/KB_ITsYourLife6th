package advanced.ch17.sec06.exam01;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class Student {
    private String name;
    private int score;

    // 모든 필드를 초기화하는 생성자
//    public Student(String name, int score) {
//        this.name = name;
//        this.score = score;
//    }

    // Getter 메서드
//    public String getName() { return name; }
//    public int getScore() { return score; }

}
