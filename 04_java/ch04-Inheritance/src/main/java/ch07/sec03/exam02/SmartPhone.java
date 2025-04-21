package ch07.sec03.exam02;

public class SmartPhone extends Phone{
    public SmartPhone(){
        // super ()
        // 부모에 기본생성자 불가능
    }

    public SmartPhone(String model, String color){
        // 자식생성자에서는 부모 생성자를 부조건 호출
        // 부모 필드를 호출하려면 부모가 그 필드를 매개변수로 받아야하고
        // 자식 생성자에서 "super(필드에 대한 값)" 을 호출해야
        super(model, color);
        System.out.println("SmartPhone 생성자 호출됨..");
    }

    /*
    * 메소드 재정의
    * - 부모가 가지는 메소드 선언부를 그대로 사용
    * 자/
    *
    *
    *
     */

    @Override
    public void printModel() {
        super.printModel();
    }
}
