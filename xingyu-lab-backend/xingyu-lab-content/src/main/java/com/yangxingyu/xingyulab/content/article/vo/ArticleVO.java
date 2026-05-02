package com.yangxingyu.xingyulab.content.article.vo;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleVO {
    private Long id;
    private String title;
    private String summary;
    private String content;
    private String coverImage;
    private Long categoryId;
    private String categoryName;
    private Integer status;
    private Integer isTop;
    private Integer isOriginal;
    private Integer viewCount;
    private Integer likeCount;
    private Integer commentCount;
    private String tags;
    private LocalDateTime createTime;
    private String createByName;
}
