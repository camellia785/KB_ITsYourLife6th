package lecture.problem;

public class Application {
    public static void main(String[] args) {

        //드라큘라(200), 프랑켄슈타인(300), 미이라(400)
        Monster monster1 = new Monster();
        monster1.setKinds("드라큘라");
        monster1.setHp(200);

        Monster monster2 = new Monster();
        monster2.setKinds("프랑켄슈타인");
        monster2.setHp(300);

        Monster monster3 = new Monster();
        monster3.setKinds("미이라");
        monster3.setHp(400);

        System.out.println("monster1.kinds = " + monster1.getKinds());
        System.out.println("monster1.kinds = " + monster1.getHp());

        System.out.println("monster2.kinds = " + monster1.getKinds());
        System.out.println("monster2.kinds = " + monster1.getHp());

        System.out.println("monster3.kinds = " + monster1.getKinds());
        System.out.println("monster3.kinds = " + monster1.getHp());

    }
}
