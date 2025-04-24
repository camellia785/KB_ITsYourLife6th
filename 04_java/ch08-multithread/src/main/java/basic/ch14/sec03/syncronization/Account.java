package basic.ch14.sec03.syncronization;

public class Account {
    private int balance = 10000;
    public void withdraw(int money) {

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
