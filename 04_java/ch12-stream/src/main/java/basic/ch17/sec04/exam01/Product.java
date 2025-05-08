package basic.ch17.sec04.exam01;

import lombok.*;

@AllArgsConstructor
@Data

public class Product {
    private int pno;
    private String name;
    private String company;
    private int price;
}
