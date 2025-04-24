package lecture.date;

import java.util.Calendar;

public class Application1 {
    public static void main(String[] args) {
        // Calendar 0월부터 시작
        Calendar cal = Calendar.getInstance();
        cal.set(2025,4,24);
        System.out.println("Calendar.set(2025.3.23) -> 실제 월:  " + cal.getTime());
    }
}
