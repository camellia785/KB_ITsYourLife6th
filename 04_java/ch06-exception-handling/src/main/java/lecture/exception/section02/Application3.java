package lecture.exception.section02;

import lecture.exception.section01.ExceptionTest;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args){

        ExceptionTest et = new ExceptionTest();
        Scanner sc = new Scanner(System.in);

        System.out.println("물건의 가격을 입력해주세요 :");
        int price = sc.nextInt();

        System.out.println();

        System.out.println("소지한 돈을 입력해주세요 :");
        int money = sc.nextInt();
        System.out.println();

        /*
        * 예외 처리 방법
        * - try-catch 처리*/

        try {
            et.checkEnoughMoney(1000,5000);
            System.out.println("========상품구입가능==============");
        } catch (Exception e) {
            System.out.println("========상품구입불가==============");
            // 예외처리구문과 상관없이 반드시 수행해야하는 경우 작성
            // 예외적으로 자원 반납시 많이 사용함

        } finally {
            sc.close();
        }

        System.out.println("프로그램 종료");
    }
}
