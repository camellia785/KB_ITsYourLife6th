package lecture.exception.section02;

public class ExceptionTest2 {
    public void checkEnoughMoney(int price, int money) throws Exception {
        if(price < 0) {
            throw new PriceNegativeException("가격은 음수 일 수 없습니다.");

        }
        if(money < 0) {
            throw new PriceNegativeException("가지고 있는 돈은 음수 일 수 없습니다.");
        }

        // 가지고 있는 돈이 부족할때
        if(money >= price) {
            System.out.println("상품을 구입하기 위한 금액이 충분합니다.");
        } else {
            throw NotEnoughMoneyException("가지고 있는 돈보다 가격이 비쌉니다.")
        }
    }
}
