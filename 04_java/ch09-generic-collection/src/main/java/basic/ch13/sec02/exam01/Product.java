package basic.ch13.sec02.exam01;

public class Product<K, M> {
    // 제네릭타입 K M 으로 운영
    private K kind;
    private M model;

    // getter setter 정의
    public K getKind() {
        return kind;
    }

    public void setKind(K kind) {
        this.kind = kind;
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }
}
