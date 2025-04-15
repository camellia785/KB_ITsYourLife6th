package test;

public class VariableTest { //자바파일명과 class명이 반드시 같아야함.
    public static void main(String[] args) {

        /*
            - 자바는 ;생략 불가능, 엄격한 문법, 대소문자 구분
            - 자바 소스파일명은 반드시 대문자로 시작
            - 변수명은 소문자로 시작, 낙타표기법 사용
            - 자바 소스파일은 클래스 파일 하나임.
            - 자바는 전역변수가 없음.(모든 변수는 class안에 선언되어야 함.)
              //자바에서 전역변수로 부르는 것들은 class바로 아래 선언된 변수를 부르는 것임.
            - 변수를 선언할 때(만들 때) 변수에 저장할 데이터의 타입에 해당하는 키워드를 앞에 써줌.
            - 선언할 때 사용한 타입 이외의 값을 변수에 넣을 수 없음(정적 타입핑)
            - 변수는 기본형 데이터, 참조형 데이터로 나뉨.
            - 기본형 변수 : 기본형 데이터가 들어가는 변수
            - 참조형 변수 : 기본형 이외의 주소가 들어가는 변수
                1) 기본형 데이터: 변수에 하나의 값을 넣는 단순한 데이터
                                  정수, 실수, 문자 한 개, 논리(boolean) 4가지
                2) 참조형 데이터: 여러개의 값으로 구성된 단순하지 않은 데이터
                                  배열, 클래스(객체), 인터페이스 등
         */

        //1. 정수
        //나이(age, 127이하)
        //올해 년도(year, 3만 이하)
        //sns조회 수(hit, 21억 이하)
        //내 미래 은행 잔고(money, 22억 이상)
        byte age = 127;
        short year = 3000;
        int hit = 2100000000;
        long money = 2200000000000L;
        //21억 넘는 값을 넣을 때 L, l을 안쓰면 컴파일 에러
        //21억보다 작은 값을 넣을 때는 생략 가능

        //2. 실수
        //내 몸무게(w, 소숫점 7자리 이하)
        //내 키(h, 소수점 15자리)

        float w = 70.5f;
        //float의 데이터는 반드시 맨 끝에 F, f를 써주어야함.
        //컴파일러가 f를 써주지 않으면 double로 인식하여 컴파일 에러를 일으킴.
        double h = 170.55555555;

        //3. 문자 한 개
        //성별
        char gender = '여'; //char타입의 데이터를 변수에 넣을 때 반드시 '(홑따옴표)를 사용해야함.

        //4. 논리형(boolean)
        //아침먹었는지 여부
        boolean food = true;

        System.out.println("내 나이는 " + age + "세야.");
        System.out.println("내 몸무게 " + w + "kg이야.");
        System.out.println("내 성별은 " + gender + "자야.");
        System.out.println("나는 오늘 아침을 먹었을까? " + food);

//        내 나이는 127세야.
//        내 몸무게 70.5kg이야.
//        내 성별은 여자야.
//        나는 오늘 아침을 먹었을까? true

        //기본형은 아니지만, 일부 기능을 기본형 문법으로 간단히 쓸 수 있는 특별한 부품(클래스)
        //String(문자열)
        String name = "김국민"; //String타입의 데이터는 반드시 "이중 따옴표를 사용함.
        String plan = """
                나는 
                당당한 
                대한민국 
                사람이야
                -----
                """; //jdk13버전부터
        System.out.println("내 이름은 " + name + "이야");
        System.out.println("내 미래 계획은 " + plan);
        //내 이름은 김국민이야
        System.out.printf("내 이름은 %s이야", name);
        //print()는 출력후 enter를 치지 않음.
        //printf(형식지정, 형식에 넣을 변수)는 출력시 형식을 지정할 수 있음.(ppt 58)
        //내 이름은 김국민이야
        System.out.printf("내 몸무게는 %.2f이고, 내 키는 %10.3f이야", w, h);
        //내 이름은 김국민이야내 몸무게는 70.50이고, 내 키는    170.556이야

        //main()안에서 선언된 변수는 main()밖에서는 인식이 되지 않기 때문에 사용 불가능함.(ppt 54)
        //변수가 선언된 { }블록을 찾아라! 블록안에서만 사용가능!
        //예) for문 안에서 만들어진 변수이면 for문 안에서만 사용 가능
        //    if문 안에서 만들어진 변수이면 if문 안에서만 사용 가능
    }
}