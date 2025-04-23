package ch11.sec05;

public class ThrowsExample1 {
    public static void main(String[] args) {
        try {
            findClass();
        } catch (ClassNotFoundException e) {
            System.out.println("예외 처리:"+ e.toString());
        }
    }
    // throw 처리
    private static void findClass() throws ClassNotFoundException {
        // 존재하지 않는 클래스 이름 ->ClassNotFoundException 발생
        Class.forName("java.lang.String2");

    }
}
