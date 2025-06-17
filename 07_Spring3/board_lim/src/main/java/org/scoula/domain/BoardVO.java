package org.scoula.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BoardVO {
    private Long no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;

    // 첨부파일 목록 추가
    private List<BoardAttachmentVO> attaches;
}

