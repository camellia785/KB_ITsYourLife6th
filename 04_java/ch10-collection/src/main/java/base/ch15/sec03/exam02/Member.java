package base.ch15.sec03.exam02;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

//import java.util.Objects;

@EqualsAndHashCode
@AllArgsConstructor

public class Member {
    public String name;
    public int age;

//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Member member = (Member) o;
//        return age == member.age && Objects.equals(name, member.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
}
