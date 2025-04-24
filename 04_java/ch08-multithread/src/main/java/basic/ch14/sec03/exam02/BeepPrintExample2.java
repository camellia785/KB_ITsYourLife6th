package basic.ch14.sec03.exam02;

import java.awt.*;

public class BeepPrintExample2 {
    public static void main(String[] args) {
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