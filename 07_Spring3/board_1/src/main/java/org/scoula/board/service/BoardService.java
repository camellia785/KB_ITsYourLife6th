package org.scoula.board.service;

import org.scoula.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    // 전체조회
    public List<BoardDTO> getList();

    // 게시글 단건조회
//    public BoardDTO

    // 게시글 생성
    public void create(BoardDTO board);

    // 게시글 생성
    public boolean update(BoardDTO board);

    // 게시글 삭제
    public boolean delete(Long no);
}