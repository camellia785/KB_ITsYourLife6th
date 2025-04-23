package lecture.exception.section01;

public class Application {
    public static void main(String[] args){

        ExceptionTest et = new ExceptionTest();

        /*
        * 예외 처리 방법
        * - try-catch 처리*/
        try {
            et.checkEnoughMoney(1000,5000);
        } catch (Exception e) {
            System.out.println("========상품구입불가==============");
        }

        System.out.println("프로그램 종료");
    }
}
