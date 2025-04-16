package basic.ch06.sec07.exam02;

public class Korean {
    //필드 선언
    String nation = "대한민국"; //기본값 지정
    String name;
    String ssn;

    // 생성자 선언, name/ssn만
    public Korean(String name, String ssn) {
        this.name = name; // 생성자에서 받은 매개변수 name을 필드에 할당
        this.ssn = ssn;
    }

}
