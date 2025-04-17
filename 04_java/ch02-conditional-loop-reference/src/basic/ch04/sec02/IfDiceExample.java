package basic.ch04.sec02;

import java.util.Random;

public class IfDiceExample {
    public static void main(String[] args) {
//        int num = (int)(Math.random() * 6) + 1;

        // 1-6사이의 값을 랜덤
        // Math.random : 0-1미만 난수반환 (double)
        int num = (int)(Math.random() * 6) + 1;
        Random rand = new Random();

        //0~인자로 준 값(bound)
        num = rand.nextInt(6) + 1;

        if (num == 1) {
            System.out.println("You are 1 dice");
        } else if (num == 2) {
            System.out.println("You are 2 dice");
        } else if (num == 3) {
            System.out.println("You are 3 dice");
        } else if (num == 4) {
            System.out.println("You are 4 dice");
        } else if (num == 5) {
            System.out.println("You are 5 dice");
        } else if (num == 6) {
            System.out.println("You are 6 dice");
        }



    }
}
