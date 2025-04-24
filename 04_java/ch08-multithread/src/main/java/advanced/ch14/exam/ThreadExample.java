package advanced.ch14.exam;

public class ThreadExample {
    public static void main(String[] args) {
        // 1. MovieThread는 Thread 클래스를 상속했기 때문에 바로 생성 후 start() 가능
        MovieThread movieThread = new MovieThread();
        movieThread.start();

        // 2. MusicRunnable은 Runnable을 구현했기 때문에 Thread에 넣어줘야함
        Runnable musicRunnable = new MusicRunnable(); // Runnable 구현 객체
        Thread musicThread = new Thread(musicRunnable); // Runnable을 실행할 Thread 객체
        musicThread.start();

    }
}
