package basic.ch13.sec02.exam02;

public class GenericExample {
    public static void main(String[] args) {
        // HomeAgency
        HomeAgency homeAgency = new HomeAgency();
        Home home = homeAgency.rent();

        home.turnOnLight();

        // CarAgency
        CarAgency carAgency = new CarAgency();
        Car car = carAgency.rent();

        car.run();
    }
}
