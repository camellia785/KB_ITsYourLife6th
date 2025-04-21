package ch07.sec07.exam03;

public class ChildExample {
    public static void main(String[] args) {
        Parent parent = new Child(); // 업캐스팅

        parent.field1 = "data1";
        parent.method1();
        parent.method2();

//        parent.field2 = "data2"; //오류발생
//        parent.method3(); //오류발생

        // 자식 타입으로 강제 형변환(다운캐스팅)
        Child child = (Child) parent; //다운캐스팅

        child.field2 = "data2";
        child.method3();
    }
}
