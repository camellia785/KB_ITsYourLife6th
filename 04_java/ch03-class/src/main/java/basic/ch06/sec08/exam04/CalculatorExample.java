package basic.ch06.sec08.exam04;

public class CalculatorExample {
    public static void main(String[] args) {

        double pi = Calculator.PI;
        System.out.println(pi);

        Calculator cal1 = new Calculator();
        cal1.z = 10;
        System.out.println(cal1.z);
//        cal1.PI = 15;

        Calculator cal2 = new Calculator();
        cal2.z = 20;
        System.out.println(cal2.z);

        System.out.println("cal2.PI: " + cal2.PI);




//        //인스턴스를 만들고
//        Calculator cal = new Calculator();
//        System.out.println(cal.plus((int)pi,5));

//        // 인스턴스를 만들지 않아도 클래스 이름.""으로 참조가능
//        System.out.println(Calculator.plus((int)pi,5));


    }
}

