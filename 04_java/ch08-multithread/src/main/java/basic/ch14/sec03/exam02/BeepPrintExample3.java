package basic.ch14.sec03.exam02;

import java.awt.*;

public class BeepPrintExample3 {
    public static void main(String[] args) {
        // 익명 클래스: 이름없이 인터펭스나 추상클래스를 즉석에서 구현하는
        // 익명 객체: 익명 클래스로 만든 객체

        // Thread 클래스로 run() 을 구현하는 경우 상속으로 하기 때문에
        // 추가로 다른 기능들은 상속할 수 없음

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    // 스레드한테 시킬 일
                    // Toolkit 도구모움 클래스
                    // beep
                    Toolkit toolkit = Toolkit.getDefaultToolkit();

                    for (int i = 0; i < 5; i++) {
                        toolkit.beep();
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            // 예외가 발생한 위치 경로를 알려줌 (콘솔출력)
                            e.printStackTrace();
                        }
                    }

                }

        });

        // 별도의 작업 스레드 생성
        thread.start();

        // 메인 스레드에서 toolkit 사용하려면 여기에도 선언 필요!
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        //메인 스레드에서는 for문 동작
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}