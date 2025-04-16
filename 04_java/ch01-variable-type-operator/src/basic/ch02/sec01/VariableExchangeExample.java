package basic.ch02.sec01;

public class VariableExchangeExample {
    public static void main(String[]args) {
        int x= 3;
        int y= 5;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println(" ----------" );

        // 값 교환 temp
        int temp = x;
        x = y;
        y = temp;

        System.out.println("x: "+x+"y: "+y);
    }
}
