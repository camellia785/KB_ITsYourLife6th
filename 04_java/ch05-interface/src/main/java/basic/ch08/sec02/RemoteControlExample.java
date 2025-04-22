package basic.ch08.sec02;

public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc;

        // rc 변수에 television 객체 대입
        rc = new Television(); //자동형변환
        rc.turnOn();

        // rc 변수에 Audio 객체를 대입(교체시키기)
        rc = new Audio(); //자동형변환
        rc.turnOn();

    }
}
