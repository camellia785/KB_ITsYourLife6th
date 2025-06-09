package org.scoula.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {

    private String name;

    // 2. 필드 의존성 주입
    // @Autowired
    private Parrot parrot;

    public Parrot getParrot() {
        return parrot;
    }

    public String getName() {
        return name;
    }

    // 1. set을 사용한 의존성 주입
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
    public void setName(String name) {
        this.name = name;
    }
}
