package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class ExampleController2 {
    /*
    * @RequestParm
    * @PathVariable
    * @ModelAttribute
    * */

    // 컨트롤러 메서드가 void 형태면
    // 요청 url을 기준으로 뷰 이름을 추론하여 해당 뷰를 찾는다.
    
    @GetMapping("/index")
    public void get(){
        log.info("get ==============> 호출됨");
    }

}
