package lecture.book;

import java.lang.reflect.Field;

public class Book {

    // author, title, pageCount, coverType
    // 필드
    String author;
    String title;
    String coverType;
    int pageCount;

    // 생성자
    // 생성자 메소드는 반드시 클래스의 이름과 동일해야한다. (대/소문자까지)
    // 생성자 메소드는 반환형을 작성하지 않는다. (작성하게되면 일반 메소드로 인식한다.)

    // 기본생성자 (매개변수가 없는 생성자)
    // 매개변수 있는 생성자가 하나라도 있으면 컴파일러가 자동으로 기본생성자를 만들어주지 않는다!!!!!!!
    public Book() {
        System.out.println("기본 생성자 호출함 .....");
    }



    //전체 생성자
    public Book(String author, String title, String coverType, int pageCount) {
        this.author = author;
        this.title = title;
        this.coverType = coverType;
        this.pageCount = pageCount;
    }

    // getter 맥북: ctrl+enter
    public String getTitle() {
        System.out.println(title + "책의 작가는" + author + "입니다.");
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", coverType='" + coverType + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }
// 메서드

}
