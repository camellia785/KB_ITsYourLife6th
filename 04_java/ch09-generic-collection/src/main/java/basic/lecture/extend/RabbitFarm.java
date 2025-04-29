package basic.lecture.extend;

//인터페이스인 Animal
//인터페이스 타입으로 제한할 시에도 implements가 아닌 extends를 사용
//public class RabbitFarm<T extends Animal> {
//}

//T 타입변수는 Rabbit 타입 혹은 Rabbit 하위 타입들만 가능
//T의 타입을 제한하기 위해 사용함
public class RabbitFarm<T extends Rabbit> {
    private T animal;

    public RabbitFarm(){

    }
    public RabbitFarm(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}