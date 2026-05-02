package com.yangxingyu.xingyulab.content.resource.vo;

import lombok.Data;

@Data
public class ResourceVO {
    private Long id;
    private String title;
    private String description;
    private String url;
    private String category;
    private String icon;
    private Integer sortOrder;
}
