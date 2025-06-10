package org.scoula.config;

import org.scoula.domain.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스를 Bean 설정 클래스라고 Spring에 알림
public class ProjectConfig {

    @Bean // Spring이 이 메서드를 호출해서 반환값을 Bean으로 등록함
    public Parrot parrot(){
        Parrot parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }
}
