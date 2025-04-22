package basic.ch08.lecture;

public interface InterProduct {
    /*
    * 인터페이스는 상수필드만 작성 가능
    * - public static final -> 조합을 상수필드 -> 선언과 동시에 초기화해야함
    * */

    // public static final int a=0;
    // public static final 이 숨어있음 -  final있으면 초기화 안되니까
    // 상수는 대문자
    int MIN_NUM=10;
    int MAX_NUM=100;

    // 생성자를 가질 수없음
//    public InterProduct(){}

    //인터페이스는 구현부가 있는 메서드를 가질 수 없다.
//    public void nonStaticMethod(){}

    // static 메서드는 가질 수 있음 (java 8버전 이후)
    public static void staticMethod(){
        System.out.println("InterProduct 인터페이스에서 staticMethod 호출됨....");
    }

    // 인터페이스에서 일반 메소드를 만들기 위해서는 default 키워드를 붙여야함
    public default void defaultMethod(){
        System.out.println("InterProduct 인터페이스에서 defaultMethod 호출됨....");
    };


    // 추상 메서드만 작성 가능
    public abstract void nonStaticMethod();

    /*
    * 인터페이스 안에 작성한 메소드는 public abstract의 의미를 가진다.
    * 인터페이스를 상속받은 클래스는 메소드를 구현할때,
    * 접근제어자를 public으로 해야지 구현 가능함.*/
    void abstMethod();
}
