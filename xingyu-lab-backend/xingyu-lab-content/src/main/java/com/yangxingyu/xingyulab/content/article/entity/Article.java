package com.yangxingyu.xingyulab.content.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("content_article")
public class Article extends BaseEntity {
    private String title;
    private String summary;
    private String content;
    private String coverImage;
    private Long categoryId;
    private Integer status;       // 0草稿 1已发布 2置顶
    private Integer isTop;
    private Integer isOriginal;
    private String source;
    private String sourceUrl;
    private Integer viewCount;
    private Integer likeCount;
    private Integer commentCount;
    private String tags;
}
