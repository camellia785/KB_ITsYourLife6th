package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// tbl_board를 매핑할 ValueObject 만들기
public class BoardVO {
    private Long no; // pk
    private String title;
    private String content;
    private String writer;
    private Date reg_date; // 등록일
    private Date update_date; // 수정일

}
