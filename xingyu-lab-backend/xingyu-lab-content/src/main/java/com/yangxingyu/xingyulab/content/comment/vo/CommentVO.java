package com.yangxingyu.xingyulab.content.comment.vo;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommentVO {
    private Long id;
    private Long articleId;
    private Long parentId;
    private String nickname;
    private String content;
    private Integer likeCount;
    private LocalDateTime createTime;
    private List<CommentVO> replies;
}
