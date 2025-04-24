package basic.ch14.sec03.syncronization;

public class SafeAccount {
    // 공유자원: 여러 스레드가 동시에 접근가능한 데이터
    private int balance = 10000;

    /*
    * synchronized
    * -> 한번에 하나의 스레드만 특정 코드영역에 들어올 수 있도록 막아주는 키워드
    * -> 락(lock)
    * */
    public synchronized void withdraw(int money) {

        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            balance -= money;
        }
    }
    public int getBalance(){
        return balance;
    }
}
