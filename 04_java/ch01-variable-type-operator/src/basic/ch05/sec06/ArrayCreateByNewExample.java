package basic.ch05.sec06;

public class ArrayCreateByNewExample {
    public static void main(String[] args) {
        // 배열 선언만 하고 초기화하지 않은 상태에서 출력하기
        int[] arr1 = new int[3];
        for (int i=0; i< arr1.length; i++){
            System.out.println("arr1[" + i + "]: "+ arr1[i]);
        }
        System.out.println("------");

        String[] arr2 = new String[3];
        for(int i=0; i< arr2.length; i++) {
            System.out.println("arr2[" + i + "]:"+ arr2[i]);
        }


    }
}
