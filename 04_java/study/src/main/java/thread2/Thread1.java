package main.java.thread2;

public class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println("증가: "+ i);
        }
    }
}
