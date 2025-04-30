package base.ch15.sec06.exam01;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Coin {
    private int value;

    // int를 string으로 나오게끔 하려고  + "" 붙여줘야함
    @Override
    public String toString() {
        return value + "";
    }
}
