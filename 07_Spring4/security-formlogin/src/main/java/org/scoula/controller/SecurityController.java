package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@RequestMapping("/security")
@Controller
public class SecurityController {

//
    @GetMapping("/all")
    public void doAll(){
        ///security/all : 모두 접근 가능
        log.info("do all can access everybody");
    }

    @GetMapping("/member") // MEMBER 또는 ADMIN 권한 필요
    public void doMember() {
        // /security/member: ROLE_MEMBER 권한인 경우 접근 가능
        log.info("logined member");

    }
    @GetMapping("/admin") // ADMIN 권한 필요
    public void doAdmin(){
        // /security/admin: ROLE_ADMIN, ROLE_MEMBER 권한인 경우 접근 가능
        log.info("admin only");
    }

    @GetMapping("/login")
    public void doLogin(){

        log.info("로그인 페이지로 전환");
    }

    @GetMapping("/logout")
    public void doLogout(){

        log.info("로그아웃 페이지로 전환");
    }



}
