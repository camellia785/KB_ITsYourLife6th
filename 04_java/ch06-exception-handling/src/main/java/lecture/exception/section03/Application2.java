package lecture.exception.section03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {
        //BufferedReader : 파일을 읽어오는 클래스
        BufferedReader in = null;

        /* try-with-resource
        - close 해줘야하는 인스턴스의 경우 try 옆에 소괄호 안에서 생성하면
        - 해당 try-catch 블럭이 완료될때 자동으로 close
        * */

        try(BufferedReader in = new BufferedReader(new FileReader("hello.txt") )
        {

            String s;

            in.close();
            
            while((s = in.readLine()) != null){
                System.out.println(s);
            }
            // catch 블럭을 여러개 작성할때
            // 상위 타입이 하단에 오고
            // 후손 타입이 상단에 온다
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException 발생!");
        } catch (IOException e) {
            System.out.println("IOException 발생!");
        }
    }
}
