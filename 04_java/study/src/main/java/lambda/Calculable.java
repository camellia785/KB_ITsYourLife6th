package main.java.lambda;

@FunctionalInterface
public interface Calculable { // 함수형 인터페이스 설정
    //추상 메소드 하나만 가져야한다.
    //@ = 어노테이션, Annotation,,
    void calculate(int x, int y);
}