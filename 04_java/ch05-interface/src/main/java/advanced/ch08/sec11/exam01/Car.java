package advanced.ch08.sec11.exam01;

public class Car  {
        // Tire 타입의 tire1 tire2 변수 정의
        Tire tire1 = new HankookTire();
        Tire tire2 = new KumhoTire();

        //메소드
        void run(){
            tire1.roll();
            tire2.roll();
        }

    }

