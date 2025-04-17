package basic.ch05.sec06;

public class ArrayLengthExample {
    public static void main(String[] args) {
        // 정수요소 integer
        int[] arr1 = {84, 90, 96};

        int sum = 0;

        for (int i=0; i < arr1.length; i++){
            sum += arr1[i];
        }
        System.out.println("총합 : " + sum);

        double avg = (double) sum/arr1.length;
        System.out.println("평균 : " + avg);

    }
}
