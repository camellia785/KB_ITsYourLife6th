package org.scoula.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 싱글톤
@Controller
public class HomeController {

    // 요청하나당 함수 하나!
    // 요청이 어떻게 들어오는지 설정
    // 어떤 함수를 부를지 정의함.

    @GetMapping("/")    // "/" 주소로 get 요청이 들어오면
    public String home(Model model){
        System.out.println("HomeController ======");

        model.addAttribute("name", "홍길동");

        return "index"; // view 파일 이름 프론트컨트롤러에서 리턴함

        // 뷰리졸버가 /WEB-INF/views/index.jsp를 붙여서
    }

}
