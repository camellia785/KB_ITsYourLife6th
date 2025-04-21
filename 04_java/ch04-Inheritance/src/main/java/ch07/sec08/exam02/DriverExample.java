package ch07.sec08.exam02;

public class DriverExample {
    public static void main(String[] args){
        // Driver 객체 생성
        Driver driver = new Driver();

        //📍 매개값으로 Bus 객체를 제공하고 driver() 메소드 호출
        Bus bus = new Bus();
        driver.drive(bus);
        // driver.drive(new Bus()); 와 동일

        //📍 매개값으로 Taxi 객체를 제공하고 driver() 메소드 호출
        Taxi taxi = new Taxi();
        driver.drive(taxi);
        // driver.drive(new taxi()); 와 동일

    }
}
