package com.yangxingyu.xingyulab.content.comment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentDTO {
    @NotNull(message = "文章ID不能为空")
    private Long articleId;
    private Long parentId;
    private String nickname;
    @NotBlank(message = "评论内容不能为空")
    private String content;
}
