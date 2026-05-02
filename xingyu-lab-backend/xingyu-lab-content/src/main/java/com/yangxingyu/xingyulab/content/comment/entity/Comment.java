package com.yangxingyu.xingyulab.content.comment.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("content_comment")
public class Comment extends BaseEntity {
    private Long articleId;
    private Long parentId;
    private Long userId;
    private String nickname;
    private String content;
    private String ip;
    private String userAgent;
    private Integer status;
    private Integer likeCount;
}
