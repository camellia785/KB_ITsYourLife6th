package basic.ch08.sec10.exam02;

public class CastingExample {
    public static void main(String[] args) {

        Vehicle vehicle = new Bus();
        vehicle.run();
//        vehicle.checkFare();

        // 강제 타입 변환 후 호출
        // 이유) 자바에서는 부모 타입(인터페이스 포함)으로 생성된 객체를
        // 다시 자식 타입으로 "내려서" 사용 가능 => 다운캐스팅
        Bus bus = (Bus) vehicle;
        bus.run();
        bus.checkFare();
    }

}
