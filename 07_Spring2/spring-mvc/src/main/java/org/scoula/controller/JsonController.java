package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.dto.LoginRequestDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequestMapping("/json")
public class JsonController {

    /*
    * @ResponseBody
    * - 리턴되는 객체가 View가 아니라 "HTTP Response Body(JSON)"로 직렬화되어 전송됨
    * - Jackson 라이브러리를 통해 JSON으로 변환
    *  */
    @ResponseBody
    @GetMapping("/ex01")
    public LoginRequestDTO example() {
        log.info("/json/ex01 GET요청 진행 =========");
        LoginRequestDTO dto = new LoginRequestDTO("user","1234");

        return dto;
    }
    /*
    * @RequestBody
    * - 클라이언트가 보낸 json 형식의 데이터를 자바 객체로 자동 변환 (역직렬화)
    * - 주로 json 데이터가 body에 포함될경우 사용 (POST, PUT)
    *
    * @ResponseEntity
    * - 응답 본문, 상태코드, 헤더를 직접 제어할 수 있는 응답 방식
    *
    * */

    @PostMapping("/ex02")
    public ResponseEntity<String> example2(@RequestBody LoginRequestDTO dto){

        log.info("받은 데이터 ================== {}", dto.getId());
        log.info("받은 데이터 ================== {}", dto.getPassword());

        return ResponseEntity.ok("ID : " + dto.getId() + ", PW : " + dto.getPassword());
    };

    @GetMapping("/ex03")
    public ResponseEntity<String> example3(){

        String body = "BODYBODYBODYBODYBODYBODYBODYBODYBODY";
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type","application/json;charset=UTF-8");

        return new ResponseEntity<>(body, header, HttpStatus.CREATED);
    }

}
