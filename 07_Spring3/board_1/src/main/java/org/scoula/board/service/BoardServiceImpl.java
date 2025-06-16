package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
//@Service //@Component + 서비스역할의 클래스라는 것이 스프링에 등록
public class BoardServiceImpl implements BoardService {

    //전처리해서 dao의 메서드를 불러서 db처리해달라고 해야함.
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getList() {
        //List<BoardVO> list =  boardMapper.getList();
        //vo, vo, vo, vo, vo, vo
        //dto, dto, dto, dto, dto
        return boardMapper.getList().stream() // BoardVO의 스트림
                .map(BoardDTO::of)
                // BoardDTO의 스트림
                .toList();
    // List<BoardDTO> 변환
    }

//    @Override
    public BoardDTO get(Long no) {
        BoardVO vo = boardMapper.get(no);
        //다른 곳으로 넘길 때는 dto로 만들어서 넘기자.
        BoardDTO dto = BoardDTO.of(vo);
        return dto;
    }

    @Override
    public void create(BoardDTO board) {

        // 전달받은 BoardDTO를 vo로 변환
        BoardVO boardVo = board.toVo();

        // db
        boardMapper.create(boardVo);

        // 게시글 수정 서비스


        // Vo에 생성된 pk값을
        // DTO에 전달 -> 후속작업이 필요할때만
        board.setNo(boardVo.getNo());
    }

    // 게시글 수정 서비스
    @Override
    public boolean update(BoardDTO board) {
        log.info("update......" + board);

        int affectedRows = boardMapper.update(board.toVo());  // 영향받은 행 수 반환
        return affectedRows == 1;                        // 1개 행이 수정되면 성공
    }

    // 게시글 삭제 서비스
    @Override
    public boolean delete(Long no) {
        log.info("delete...." + no);

        int affectedRows = boardMapper.delete(no);     // 삭제된 행 수 반환
        return affectedRows == 1;                 // 1개 행이 삭제되면 성공
    }

}
