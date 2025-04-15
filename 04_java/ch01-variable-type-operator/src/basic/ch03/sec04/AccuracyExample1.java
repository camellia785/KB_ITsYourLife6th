package basic.ch03.sec04;

public class AccuracyExample1 {
    public static void main(String[] args) {
        // 컴퓨터는 소수를 이진수로 완벽하게 계산이 불가능

//        int apple = 1;
//        double pieceUnit = 0.1;
//        int number = 7;
//
//        double result = apple - number*pieceUnit;
//        System.out.println("사과 1개에서 남은 양: " + result);
        int apple = 10;
        double pieceUnit = 1;
        int number = 7;

        double result = apple - number*pieceUnit;
        System.out.println("사과 1개에서 남은 양: " + result/10);
    }
}
