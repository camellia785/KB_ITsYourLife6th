package basic.ch13.sec02.exam01;

public class GenericExample {
    public static void main(String[] args) {
        // K: <Tv타입, 문자>
        Product<Tv, String> product1 = new Product<>();
        product1.setKind(new Tv());
        product1.setModel("스마트Tv");

        // getter의 리턴값이 Tv타입
        Tv tv = product1.getKind();

        // 문자열로 리턴되니까 String타입으로 맞춰주는
        String tvModel = product1.getModel();

        // M: 동일
        Product<Car, String> product2 = new Product<>() ;
        product2.setKind(new Car());
        product2.setModel("SUV자동차");

        Car car = product2.getKind();
        String carModel = product2.getModel();
    }
}
