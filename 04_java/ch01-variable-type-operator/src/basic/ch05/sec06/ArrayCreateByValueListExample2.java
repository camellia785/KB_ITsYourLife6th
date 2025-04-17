package basic.ch05.sec06;

public class ArrayCreateByValueListExample2 {
    public static void main(String[] args) {
        int[] scores = new int[] {83, 90, 87};
        printItem(scores);
    }

    // 정수 배열을 받아 각 요소를 출력하는 메서드 정의
    public static void printItem(int[] arr) {
        for (int i=0; i < arr.length; i++){
            System.out.println("score[" + i + "]: "+ arr[i]);
        }
    }
}
