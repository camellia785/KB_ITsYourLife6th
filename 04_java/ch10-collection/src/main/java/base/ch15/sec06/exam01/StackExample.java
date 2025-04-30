package base.ch15.sec06.exam01;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Coin> coinBox = new Stack<>();

        //동전 넣기
        coinBox.push(new Coin(100));
        coinBox.push(new Coin(50));
        coinBox.push(new Coin(500));
        coinBox.push(new Coin(10));

        System.out.println("꺼내온 동전 : " + coinBox.pop() + "원");
        System.out.println("꺼내온 동전 : " + coinBox.pop() + "원");
        System.out.println("꺼내온 동전 : " + coinBox.pop() + "원");
        System.out.println("꺼내온 동전 : " + coinBox.pop() + "원");

        // 남은거 확인
        System.out.println(coinBox);


    }
}
