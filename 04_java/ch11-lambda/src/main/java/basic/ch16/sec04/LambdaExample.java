package basic.ch16.sec04;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 실행문 두개 이상
        person.action((x,y)->{
            double result = x+y;
            return result;
        });

        // sum() 메서드 호출
        /*
        * 메소드 참조
        * - 함수형 인터페이스를 람다식으로 쓰는게 아닌,
        * - 일반 메소드를 참조시켜 선언하는 방법
        *
        * 일반 메소드를 참조하기 위한 조건
        * - 각 메소드의 매개변수 타입/개수/반환형 이 같아야함
        *
        * // static
        * 클래스 이름 :: 메소드이름
        *
        * // instance
        * 참조변수 이름:: 메소드이름
        *
        * */

        person.action(LambdaExample::sum);

        person.action((x,y)-> {
            return (x+y);
        });
    }
        public static double sum(double x, double y){
            return  (x+y);
        }
    }

