package org.scoula.ex01.test.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 싱글톤 + 컨트롤러로 스프링 등록
                // 핸들러매퍼에 등록이 됨
@RequestMapping("/test") // /test/update, /test/insert
// /member/insert, /member/delete

@Log4j2
public class TestController {

    @GetMapping("")  // == GET /test
    public String test() {
        log.info("TestController ===== ");
        return "test";  // WEB-INF/views/test.jsp 와 같이 해석될 것
    }

    @GetMapping("/insert")
    public String insert(String name){
        log.info("TestController2 ===== " + name);
        return "insert";
    }
}
