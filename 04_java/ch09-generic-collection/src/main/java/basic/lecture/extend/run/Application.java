package basic.lecture.extend.run;

import basic.lecture.extend.Bunny;
import basic.lecture.extend.DrunkenBunny;
import basic.lecture.extend.Rabbit;
import basic.lecture.extend.RabbitFarm;

public class Application {
    public static void main(String[] args) {
        /*
         * [Animal] (Interface)
         * ├── [Mammal] (implements Animal)
         * │       └── [Rabbit] (extends Mammal)
         * │              └── [Bunny] (extends Rabbit)
         * │                     └── [DrunkenBunny] (extends Bunny)
         * └── [Reptile] (implements Animal)
         *         └── [Snake] (extends Reptile)
         * */
        // 제네릭 클래스 작성시 extends 키워드를 이용해서
        // 특정 타입만 제한을 걸 수 있다.
        // -> 특정 타입만 사용하도록 제한, 특정 타입 및 특정 타입의 자식타입들도 대입가능

        // Rabbit의 후손이거나 Rabbit 타입인경우만 사용가능
//        RabbitFarm<Animal> farm1 = new RabbitFarm<>();
//        RabbitFarm<Mammal> farm2 = new RabbitFarm<>();

        RabbitFarm<Rabbit> farm4 = new RabbitFarm<>();
        RabbitFarm<Bunny> farm5 = new RabbitFarm<>();
        RabbitFarm<DrunkenBunny> farm6 = new RabbitFarm<>();

        farm4.setAnimal(new Rabbit());
        farm4.getAnimal().cry();


    }
}
