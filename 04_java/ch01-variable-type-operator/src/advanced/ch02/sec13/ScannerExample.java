package advanced.ch02.sec13;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.print("x값 입력: ");
//        String str = sc.nextLine();
//
//        System.out.println("입력값 = " + str);
//
//        sc.close();

        while(true){
            System.out.print("입력 문자열: ");
            String input = sc.nextLine();
            if(input.equals("q")){
                System.out.print("종료");
                break;
            }
            else{
                System.out.println("출력 문자열: "+input + "\n");
            }
        }

        sc.close();
    }
}