package com.yangxingyu.xingyulab.content.category.vo;

import lombok.Data;

@Data
public class CategoryVO {
    private Long id;
    private String categoryName;
    private String slug;
    private String description;
    private Integer sortOrder;
    private Integer status;
    private Integer articleCount;
}
