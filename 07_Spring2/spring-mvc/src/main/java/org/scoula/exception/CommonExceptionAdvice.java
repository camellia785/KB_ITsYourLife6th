package org.scoula.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Log4j2

/*
* ControllerAdvice
* - 스프링MVC에서 전역처리를 하기위해 사용하는 특수 어노테이션*/

// 모든 종류의 예외를 처리하는 메서드
public class CommonExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public String handleIlligalArgument(Exception ex, Model model) {

        log.error("Exception 달성 =========> {}", ex.getMessage());

        model.addAttribute("exception", ex);

        return "error_page";
    };

    // 404 not found - url 경로가 매핑된게 없을때 하는 것
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404(NoHandlerFoundException ex, Model model, HttpServletRequest request) {

        log.error("handle404 달성 =========> {}");

        model.addAttribute("url", request.getRequestURI());

        return "custom404";
    };
}
