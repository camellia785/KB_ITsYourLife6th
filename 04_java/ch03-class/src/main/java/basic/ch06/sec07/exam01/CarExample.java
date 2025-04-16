package basic.ch06.sec07.exam01;

public class CarExample {
    public static void main(String[] args) {
        // 생성자를 이용해 객체 생성
        Car myCar = new Car("그랜저", "검정", 250);

        // 필드 출력
        System.out.println(myCar.model);
        System.out.println(myCar.color);
        System.out.println(myCar.speed);

    }
}
