package basic.ch05.sec06;

public class ArrayByValueListExample1 {
    public static void main(String[] args) {
        String[] season = {"Spring", "Summer", "Fall", "Winter"};

//        System.out.println("season[0] : "+ season[0]);
//        System.out.println("season[1] : "+ season[1]);
//        System.out.println("season[2] : "+ season[2]);
//        System.out.println("season[3] : "+ season[3]);

        // for 문으로도 사용가능
        for (int i=0; i < season.length; i++){
            System.out.println("season["+i+"] :" + season[i]);
        }
        System.out.println("--------");

        // score
        int[] scores = {83, 90, 87};
        int sum = 0;

        for (int i=0; i<scores.length; i++){
            sum += scores[i];
        }
        System.out.println("총합 :" + sum );

        // 평균계산: 소수점 결과를 위해 double형으로 변환 필요
        double avg = (double) sum/scores.length;
        System.out.println("평균 :" + avg);
    }
}
