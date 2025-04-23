package main.java.library;

public class SmartPhone {
    // toString()재정의 사용
    private String company;
    private String os;

    public SmartPhone(String company, String os){
        this.company = company;
        this.os = os;

    }

    @Override
    public String toString() {
        return "전화기 내용{" +
                "company='" + company + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
