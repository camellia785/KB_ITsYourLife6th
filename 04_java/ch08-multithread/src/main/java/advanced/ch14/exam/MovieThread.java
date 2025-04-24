package advanced.ch14.exam;

// 1초 간격으로 "동영상을 재생합니다" 3회 출력하는 스레드
// Thread 클래스를 상속받아 사용자 정의 스레드를 만듦
public class MovieThread extends Thread{
    @Override
    public void run() {
        // run 메서드 안에는 스레드가 할일 적기
        for (int i=0; i < 3; i++) {
            System.out.println("동영상을 재생합니다.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
