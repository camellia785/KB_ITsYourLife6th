package basic.ch05.sec05;

public class SubStringExample {
    public static void main(String[] args) {
        /*
         * SubString
         * -원하는 범위만 잘라서 새로운 문자열 반환
         *
         * 인자가 1개일때
         * - 해당 index 값에서 끝까지 반환
         *
         * 인자가 2개일때(시작 index, 끝index)
         * -시작index부터 끝index까지를 반환(끝 index에 해당하는 값은 반환X)
         * */
        String ssn = "880815-1234567";
//        String firstNum = ssn.substring(0, 6);
//        System.out.println(firstNum);
//        String secondNum = ssn.substring(7);
//        System.out.println(secondNum);

        String[] num = ssn.split("-");
        System.out.println(num[0]);
        System.out.println(num[1]);
    }
}