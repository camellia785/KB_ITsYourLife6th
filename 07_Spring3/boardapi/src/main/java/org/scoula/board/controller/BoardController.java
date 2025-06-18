package org.scoula.board.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/board")
@RequiredArgsConstructor
@Log4j2
//@Controller + @ResponseBody
@RestController //views로 넘어가지 않고 모두 data로 응답하겠다!
@Api(tags = "게시글 관리")
public class BoardController {

private final BoardService service;//생성자 주입

    @ApiOperation(value = "게시글 목록", notes = "게시글 목록을 얻는 API")
    @GetMapping("") // ==> /api/board
    //@ResponseBody//컨트롤러에서 views로 넘어가지 않고
    //http의 body에 리턴값을 넣어서 응답해라!
    public ResponseEntity<List<BoardDTO>> getList(){
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/get") // ==> /api/board/get?no=1
    public BoardDTO get(@RequestParam("no") Long no){
        return service.get(no);
    }

    @ApiOperation(value = "상세정보얻기", notes = "게시글상제정보를얻는API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로요청이처리되었습니다.", response = BoardDTO.class),
            @ApiResponse(code = 400, message = "잘못된요청입니다."),
            @ApiResponse(code = 500, message = "서버에서오류가발생했습니다.")
    })
    @GetMapping("/get/{no}") // ==> /api/board/get/15
    public BoardDTO get2(
            @ApiParam(value = "게시글 ID", required = true, example = "1")
            @PathVariable Long no){
        return service.get(no);
    }

    @PostMapping("") // ==> /api/board + post
    public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO dto){
        //@RequestBody --> 브라우저에서 보낼때도  json으로 보낼 수 있음.
        //서버에서 json을 받을 때 사용하는 어노테이션!
        log.info(" 🎀Http 요청으로 들어온 data : {}", dto);

        // service 처리요청
        BoardDTO boardDTO = service.create(dto);
        log.info("🎀create메소드 결과 data : {}", boardDTO);

        // 응답
        return ResponseEntity.ok(boardDTO);
    }
    /**
     * 게시글 수정
     * PUT: http://localhost:8080/api/board/{no}
     * @param no 수정할 게시글 번호(PK)
     * @param board 수정할 게시글 데이터 (제목, 내용 등)
     * @return ResponseEntity<BoardDTO>
     *         - 200 OK: 게시글 수정 성공 시 수정된 게시글 데이터 반환
     *         - 400 Bad Request: 잘못된 요청 데이터 (제목/내용 누락, 잘못된 번호 형식 등)
     *         - 404 Not Found: 수정할 게시글이 존재하지 않음
     *         - 500 Internal Server Error: 서버 내부 오류 발생 시
     */
    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(
            @PathVariable Long no,           // URL에서 게시글 번호 추출
            @RequestBody BoardDTO board      // 수정할 데이터 (JSON)
    ) {
        log.info("============> 게시글 수정: " + no + ", " + board);

        // 게시글 번호 설정 (안전성을 위해)
        board.setNo(no);
        BoardDTO updatedBoard = service.update(board);
        return ResponseEntity.ok(updatedBoard);
    }

    /**
     * 게시글 삭제
     * DELETE: http://localhost:8080/api/board/{no}
     * @param no 삭제할 게시글 번호(PK)
     * @return ResponseEntity<BoardDTO>
     *         - 200 OK: 게시글 삭제 성공 시 삭제된 게시글 데이터 반환
     *         - 204 No Content: 게시글 삭제 성공 (응답 데이터 불필요한 경우)
     *         - 400 Bad Request: 잘못된 게시글 번호 형식 (음수, 문자 등)
     *         - 404 Not Found: 삭제할 게시글이 존재하지 않음
     *         - 500 Internal Server Error: 서버 내부 오류 발생 시
     */
    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> delete(@PathVariable Long no) {
        log.info("============> 게시글 삭제: " + no);

        // 삭제된 게시글 정보를 반환
        BoardDTO deletedBoard = service.delete(no);
        return ResponseEntity.ok(deletedBoard);
    }
}
