package org.scoula.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;
import org.scoula.dto.LoginRequestDTO;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

@Log4j2
@Controller
public class RedirectController {
    /*
     * RedirectAttributes
     * - 리다이렉트시 데이터를 임시로 전달가능한 객체
     * - addFlashAttribute : 일회성 데이터 전송 ( 세션에 저장되어 다음요청에만 적용)
     * */

    // http://localhost:8080/example04/5
    @GetMapping("/result")
    public String registerUser(RedirectAttributes rttr) {

        log.info("회원가입 진행중 ..");

        rttr.addAttribute("message", "회원가입성공");

        return "redirect:/result";

    };
}
