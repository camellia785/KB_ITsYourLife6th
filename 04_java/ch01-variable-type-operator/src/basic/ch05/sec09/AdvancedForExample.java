package basic.ch05.sec09;

public class AdvancedForExample {
    public static void main(String[] args) {
        int[] scores = {95, 71, 84, 93, 87};

        // 점수 총합
        int sum =0;
        for(int i=0; i < scores.length; i++){
            sum += scores[i];
        }
        System.out.println("점수 총합 :" + sum);

        // 평균 점수
        double avg = (double) sum/ scores.length;
        System.out.println("평균: "+ avg);
    }
}
