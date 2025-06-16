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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;
    //BoardMapper인터페이스를 구현한 클래스의 객체를 mapper변수에 넣어주세요.!
    //spring과 mybatis가 환경설정한 것을 기반으로 해서
    //자동으로 클래스를 만들고 싱글톤도 만들어줌.

    @Test
    void getList() {
        List<BoardVO> list = mapper.getList();
        for (int i = 0; i < list.size(); i++) {
            log.info(list.get(i));
        }
    }

    @Test
    @DisplayName("BoardMapper의게시글읽기")
    public void get() {
        // 존재하는게시물번호로테스트
        BoardVO board = mapper.get(1L);
        log.info(board);
    }

    @Test
    @DisplayName("BoardMapper의새글작성")
    public void create() {
        BoardVO board = new BoardVO();
        board.setTitle("새로작성하는글");
        board.setContent("새로작성하는내용");
        board.setWriter("user00");
        mapper.create(board);
        log.info(board); // no값이 존재!
    }

    /* update */
    @Test
    @DisplayName("BoardMapper의 글 수정")
    public void update() {
        BoardVO board = new BoardVO();
        board.setNo(5L);                    // 수정할 게시글 번호
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("user00");

        int count = BoardMapper.update(board);   // 수정된 행의 개수 반환

        assertEquals(1, count);             // 1개 행이 수정되었는지 확인
        log.info("UPDATE COUNT: {}", count);
    }

    /* delete */
    @Test
    @DisplayName("BoardMapper의 글 삭제")
    public void delete() {
        int count = mapper.delete(3L);      // 삭제할 게시글 번호

        assertEquals(1, count);             // 1개 행이 삭제되었는지 확인
        log.info("DELETE COUNT: {}", count);

        // 삭제 후 조회 시 null 반환 확인
        BoardVO deletedBoard = mapper.get(3L);
        assertNull(deletedBoard);
    }

}