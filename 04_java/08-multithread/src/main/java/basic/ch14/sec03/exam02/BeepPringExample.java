package basic.ch14.sec03.exam02;

public class BeepPringExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableClass());
        thread.start();

        for(int i=0; i<5; i++){
            System.out.println("띵");
        } try {
            Thread.sleep(500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
