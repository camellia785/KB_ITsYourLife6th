package advanced.ch14.exam;

public class MusicRunnable implements Runnable{

    // run()은 메서드는 스레드가 시작되면 실행되는 작업내용

    @Override
    public void run() {
        // 6번반복
        for (int i = 0; i < 6; i++) {
            System.out.println("음악을 재생합니다.");
            // 0.5초 간격으로
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // 예외 발생하면 에러 출력
                e.printStackTrace();
            }

        }
    }
}
