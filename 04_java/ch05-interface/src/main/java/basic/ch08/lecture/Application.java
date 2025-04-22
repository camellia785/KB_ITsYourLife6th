package basic.ch08.lecture;

public class Application {
    public static void main(String[] args) {
        /*
        * 인터페이스
        * -> 자바의 클래스와 유사하지만, 추상메소드와 상수 필드만 가질 수 있는 특별한 클래스의 변형체
        *
        * 사용목적
        * - 추상클래스와 비슷하게 필요한 기능을 공통화해서 강제성을 부여하기 위해
        * - 클래스 상속의 단일상속이라는 단점해결
        * */

        // 인터페이스는 인스턴스를 생성할 수 없고, 생성자가 존재하지 않음.
//        InterProduct interProduct = new InterProduct();

        Product product = new Product();

        InterProduct interProduct = new Product();

        // 동적바인딩
        interProduct.abstMethod();
        interProduct.nonStaticMethod();

        // defaultMethod 오버라이딩
        interProduct.defaultMethod();
        InterProduct.staticMethod();

        System.out.println(InterProduct.MAX_NUM);
        System.out.println(InterProduct.MIN_NUM);



    }
}
