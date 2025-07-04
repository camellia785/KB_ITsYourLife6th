package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2

public class HomeController {

    // 요청 하나당 함수 하나
    // 요청이 어떻게 들어오는지 설정
    // 어떤 함수를 부를지 정의함

    @GetMapping("/") // "/"주소로 get 요청이 들어오면
    public String home(){

        // 스프링이 핸들러매퍼에 주소와 방식에 따른 어떤 컨트롤러의 메서드를 불러야할지 등록
        log.info("==========> HomeController /");
        return "index"; // View의 이름 // view 파일이름 프론트컨트롤러에서 리턴함

        // 뷰리졸버가 /WEB-INF/views/index.jsp를 붙여서
        // 프론트컨트롤러가 불러야할 파일명으로 만들어줌 (렌더링)

    }

    @GetMapping("/log")
    public String logTest(){

        log.info("INFO 로그입니다 ! ");
        log.warn("WARN 로그입니다 ! ");
        log.error("ERROR 로그입니다 ! ");

        return "OK";
    }

}
