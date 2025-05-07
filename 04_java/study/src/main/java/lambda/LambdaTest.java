package main.java.lambda;

public class LambdaTest {
    public static void main(String[] args) {
        action(new Calculable() {
            @Override
            public void calculate(int x, int y) {

            }
        });

    }

    public static void action(Calculable calculable){
        int x =10;
        int y = 4;
        calculable.calculate(x,y);
    }
}
