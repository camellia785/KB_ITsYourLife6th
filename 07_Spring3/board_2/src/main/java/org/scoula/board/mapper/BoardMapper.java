package org.scoula.board.mapper;

import org.apache.ibatis.annotations.*;
import org.scoula.board.domain.BoardVO;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT * FROM tbl_board ORDER BY no DESC")
    public List<BoardVO> getList();

    @Select("SELECT * FROM tbl_board WHERE no = #{no}")
    public BoardVO get(Long no);

    @Insert("INSERT INTO tbl_board (title, content, writer) VALUES (#{title}, #{content}, #{writer})")
    public void create(BoardVO board);

    @Update("UPDATE tbl_board SET title=#{title}, content=#{content}, writer=#{writer} WHERE no=#{no}")
    public int update(BoardVO board);

    @Delete("DELETE FROM tbl_board WHERE no = #{no}")
    public int delete(Long no);


}
