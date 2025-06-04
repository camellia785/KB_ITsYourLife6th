package org.scoula.ex05.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter, toString, equals, hashCode 자동 생성
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 인자로 받는 생성자

public class Member {
    // 필드, 기본생성자+전체 매개변수 생성자, Getter/Setter 메서드
    private String name;
    private String userid;
}
