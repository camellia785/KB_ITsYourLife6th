package ch12.sec03.exam05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Getter, Setter, toString, equals, hashCode 자동 생성
@NoArgsConstructor
@AllArgsConstructor

public class Member {
    private String id;
    private String name;
    private int age;
}
