package ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        // 자식타입 객체 생성
        Child child = new Child();

        //부모타입 -> child업캐스팅 ( 자식을 부모타입으로 형변환 )
        Parent parent = child;

        parent.method1();
        parent.method2();
//        parent.method3();
    }
}
