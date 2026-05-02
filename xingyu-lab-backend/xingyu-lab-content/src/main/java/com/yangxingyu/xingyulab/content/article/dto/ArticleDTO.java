package com.yangxingyu.xingyulab.content.article.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;

@Data
public class ArticleDTO {
    private Long id;
    @NotBlank(message = "文章标题不能为空")
    private String title;
    private String summary;
    @NotBlank(message = "文章内容不能为空")
    private String content;
    private String coverImage;
    private Long categoryId;
    private Integer status;
    private Integer isTop;
    private Integer isOriginal;
    private String source;
    private String sourceUrl;
    private List<Long> tagIds;
}
