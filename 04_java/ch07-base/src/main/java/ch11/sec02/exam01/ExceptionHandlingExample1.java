package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        // NullPointerException 예외처리
        try {
            int result = data.length();
            System.out.println("문자 수: " + result);
        } catch (NullPointerException e) {
            System.out.println("예외 발생: data가 null입니다.");
        }
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("Thisisjava");

        // data.length();에서 data가 null이기 때문에 .length()를 호출하면서 예외가 발생
        // 여기서 NullPointerException 발생
        printLength(null);

        System.out.println("[프로그램 종료]");
    }
}
