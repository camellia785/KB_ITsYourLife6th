package main.java.thread2;

public class ThreadUser {
    public static void main(String[] args) {
        // 스레드 객체 생성
        // 부모 = 자식: 자동형변환, 업캐스팅
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();



        // 익명클래스(run()를 재정의-override한 클래스)
        Thread t3 = new Thread(){
            @Override
            public void run() {
                for(int i=0; i<100; i++){
                    System.out.println("0424 목요일~");
            }
        }
        };

        // cpu스케줄러의 대기줄로 등록
        t1.start();
        t2.start();
        t3.start();
    }
}
