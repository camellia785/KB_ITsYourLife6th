package basic.ch05.sec09;

public class ArrayCopyExample {
    public static void main(String[] args) {
        String[] oldStrArray = {"java", "array", "copy"};

        //System.arraycopy() 이용해서 newStrArry로 복사하세요
        // 크기가 5인 새 문자열 배열 생성(초기값=null)
        String[] newStrArray = new String[5];

        // System.arraycopy(원본, 시작위치, 대상배열,복사시작위치, 복사길이)
        System.arraycopy(oldStrArray, 0, newStrArray, 0,oldStrArray.length);

        // 새 배열의 모든 요소 출력
        for (int i=0; i<newStrArray.length; i++){
            System.out.println(newStrArray[i]);
        }


    }
}
