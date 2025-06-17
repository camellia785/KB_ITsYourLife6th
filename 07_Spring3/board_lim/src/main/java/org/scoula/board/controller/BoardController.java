package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.scoula.domain.BoardAttachmentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

//    public BoardController(BoardService service) {
//        this.service = service;
//    }

    @GetMapping("/list") //board/list
    public void list(Model model) {
        //db에서 가지고 온 것 있어야함.
        //Controller --> Service --> dao
        log.info("===============> BoardController /list");
        model.addAttribute("list", service.getList());
        //요청한 주소와 views의 호출할 파일명이 같으면 return안해도됨.
    }
//    @GetMapping("/get") //board/get
//    @GetMapping("/create") //board/create(입력화면 보여줘)
//    @GetMapping("/update") //board/update(수정하기 전에 검색먼저해서 한번 보여줘)
//
//    @PostMapping("/create") //board/create(입력한거 db처리해줘)

    // 등록 폼 표시
    @GetMapping("/create")
    public void create() {
        log.info("create");
        // 뷰 이름: "board/create"
    }

    // 등록 처리
    @PostMapping("/create")
    public String create(BoardDTO board, RedirectAttributes ra) {

        // RedirectAttributes : 리다이렉트 시 데이터를 전달하는 Spring MVC 인터페이스

        // RedirectAttributes.addFlashAttribute("K", V) : 리다이렉트 후 한 번만 사용되고 자동 삭제할 데이터 추가
        // - 리다이렉트 전 -> request scope에 추가됨
        // - 리다이렉트 중 -> Session scope에 임시 저장
        // - 리다이렉트 후 -> request scope로 돌아옴

        log.info("create: " + board);           // 입력 데이터 로그
        service.create(board);                  // 게시글 생성

        ra.addFlashAttribute("message", "게시글이 등록 되었습니다.");

        //return "redirect:/board/list";          // 목록으로 리다이렉트
        return "redirect:/board/get?no=" + board.getNo(); // 등록된 게시글 상세 조회 페이지로 리다이렉트
    }

    @GetMapping({"/get", "/update"})
    public void get(@RequestParam("no") Long no, Model model) {
        log.info("/get or update");
        model.addAttribute("board", service.get(no));
        /* url에 따라 jsp 파일을 "board/get" 또는 "board/update" 반환 */
    }

    @PostMapping("/update")
    public String update(BoardDTO board) {
        log.info("update:" + board);
        service.update(board);
        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no) {
        log.info("delete..." + no);
        service.delete(no);
        return "redirect:/board/list";
    }
    /**
     * 파일 다운로드 처리
     * @param no 첨부파일 번호
     * @param response HTTP 응답 객체
     * @throws Exception
     */
    @GetMapping("/download/{no}")
    @ResponseBody  // View를 사용하지 않고 직접 응답 데이터 전송
    public void download(@PathVariable("no") Long no,
                         HttpServletResponse response) throws Exception {

        // 첨부파일 정보 조회
        BoardAttachmentVO attach = service.getAttachment(no);

        // 실제 파일 객체 생성
        // (java.io.File)
        File file = new File(attach.getPath());

        // 파일 다운로드 처리
        UploadFiles.download(response, file, attach.getFilename());
    }
}
