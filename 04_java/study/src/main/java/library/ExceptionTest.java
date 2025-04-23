package main.java.library;

public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println("1. 나는 프린트가 잘 될 예정.");

        try {
            // 문제가 발생할 것은 코드를 넣어주는 부분.
            System.out.println("2. 문제발생 코드 " + 10/0);
        } catch (Exception e) {
            // 에러발생시 처리 내용
            System.out.println("에러 발생함.");
            e.printStackTrace();
            System.out.println(e.getMessage());
      } finally {
            System.out.println("3. 나는 과연 프린트가 될까요??");
        }



    }
}
