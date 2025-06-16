package org.scoula.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardMapperTest {
    // 테스트 클래스 안에서도 스프링 DI (의존성 주입) 작동
    @Autowired
    private BoardMapper boardMapper;

    @Test
    @DisplayName("BoardMapper의 목록 불러오기")
    void getList() {
        for(BoardVO board : boardMapper.getList()){
            log.info(board);
        }
    }

    @Test
    @DisplayName("BoardMapper의 게시글 읽기")
    public void get() {
        // 존재하는 게시물 번호로 테스트
        BoardVO board = boardMapper.get(1L);

        assertNotNull(board);  // 조회 결과가 null이 아닌지 확인
        assertEquals(1L, board.getNo());  // 번호 일치 확인

        log.info("조회된 게시글: {}", board);
    }

    @Test
    @DisplayName("BoardMapper의 새글 작성")
    public void create() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("user0");

        boardMapper.create(board);

        // 생성된 PK 값이 설정되었는지 확인
        log.info("생성된 게시글: {}", board);
        log.info("생성된 게시글 번호: {}", board.getNo());
    }

    @Test
    @DisplayName("게시판 글 수정 테스트")
    void update() {
        BoardVO board = new BoardVO();
        board.setNo(1L);  // 수정할 게시글 번호
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("수정된 작성자");

        int result = boardMapper.update(board);
        log.info("수정 결과: " + result);
    }

    @Test
    @DisplayName("게시판 글 삭제 테스트")
    void delete() {
        int result = boardMapper.delete(1L);
        log.info("삭제 결과: " + result);
    }
}