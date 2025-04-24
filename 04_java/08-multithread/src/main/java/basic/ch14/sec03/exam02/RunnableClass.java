package basic.ch14.sec03.exam02;

import javax.tools.Tool;
import java.awt.*;

public class RunnableClass implements Runnable {
    @Override
    public void run(){
        // 스레드한테 시킬 일
        // Toolkit 도구모움 클래스
        // beep
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for(int i=0; i<5; i++) {
            toolkit.beep();
            try { Thread.sleep(500); } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    }

