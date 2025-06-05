package org.scoula.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping(value="/home")
    public String home(){
        System.out.println("컨트롤러 동작~!");
        return "index";
    }
}
