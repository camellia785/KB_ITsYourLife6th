package org.scoula.board.controller;

import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.log4j.Log4j2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2                           // 로깅을 위한 Lombok 어노테이션
@Controller                       // Spring MVC Controller 지정
@RequestMapping("/board")         // 기본 URL 패턴 설정
@RequiredArgsConstructor         // final 필드 생성자 자동 생성
public class BoardController {

    // 의존성 주입: BoardService를 통해 비즈니스 로직 처리
    final private BoardService boardService;

    // 목록 조회
    @GetMapping("/list")
    public void list(Model model){
        log.info("list 동작");

        List<BoardDTO> boardDTOList = boardService.getList();
        log.info("boardList 1번째 데이터 : {}" , boardDTOList.get(1));

        // boardDTO리스트 모델에 담기
        model.addAttribute("list", boardService.getList());

//        return "board/list";
    }

    // 글등록
    @PostMapping("/create")
    public String create(BoardDTO board){
        log.info("create: " + board);

        boardService.create(board);
        return "redirect:/board/list";
    }

    // 상세 조회 - 단건조회
    @GetMapping("/get")           // 두 개의 URL을 같은 메서드에서 처리
    public void get(@RequestParam("no") Long no, Model model) {
        log.info("/get");
        model.addAttribute("board", boardService.get(no)); // 특정 게시글 조회
    }
    // URL에 따라 뷰 이름 결정: "board/get" 또는 "board/update"

    // 수정 처리
    @PostMapping("/update")
    public String update(BoardDTO board) {
        log.info("update:" + board);
        boolean result = boardService.update(board);                   // 게시글 수정
        log.info("update result: " + result);

        return "redirect:/board/list";           // 목록으로 리다이렉트
    }

    // 삭제 처리
    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no) {
        log.info("delete..." + no);
        boolean result = boardService.delete(no);                      // 게시글 삭제
        log.info("delete result: " + result);
        return "redirect:/board/list";           // 목록으로 리다이렉트
    }


}