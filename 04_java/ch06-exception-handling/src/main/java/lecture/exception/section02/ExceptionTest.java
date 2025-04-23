package lecture.exception.section02;

public class ExceptionTest {
    public void checkEnoughMoney(int price, int money) throws Exception {

        // 가격이 음수일때
        // 가지고 잇는돈이 음수일때
        // 가지고 잇는돈이 부족할때

        System.out.println("현재 가지고 있는 돈은: " + money + "원 입니다.");

        try {
            et.checkEnoughMoney(price,money);
            System.out.println("==구입가능==");
        }

        System.out.println("즐거운 쇼핑 하세요 ~~~! ");


    }
}
