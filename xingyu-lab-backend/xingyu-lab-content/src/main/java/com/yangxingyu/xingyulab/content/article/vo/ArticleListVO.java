package com.yangxingyu.xingyulab.content.article.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ArticleListVO {
    private Long id;
    private String title;
    private String summary;
    private String coverImage;
    private String categoryName;
    private Integer isTop;
    private Integer viewCount;
    private Integer likeCount;
    private Integer commentCount;
    private String tags;
    private LocalDateTime createTime;
}
