package basic.ch05.sec09;

public class ArrayCopyByForExample {
    public static void main(String[] args) {
        // oldIntArray를 newIntArray 배열(요소가 5개임)로 복사
        int[] oldIntArray = {1,2,3};

        int[] newIntArray = new int[5];

        // for 문으로 기존 배열의 값을 새 배열로 복사
        for(int i=0; i < oldIntArray.length; i++){
            newIntArray[i] = oldIntArray[i];
        }


        // 배열의 모든 요소 출력 - for문으로
        for(int i=0; i < newIntArray.length; i++){
            System.out.println(newIntArray[i] + ", " ); //각요소 쉼표구분 출력
        }


    }
}
