package basic.ch08.sec08;

public class MultiInterfaceImplExample {
    public static void main(String[] args) {
        // RemoteControl 인터페이스 변수 선언
        RemoteControl rc = new SmartTelevision();

        // rc 객체생성, 인터페이스 변수 대입
        rc.turnOff();
        rc.turnOn();

        // Searcharble 인터페이스 변수 선언
        Searcharble searcharble = new SmartTelevision();

        // sa 객체 생성, 인터페이스
        searcharble.search("http://www.youtube.com");
        }
    }
