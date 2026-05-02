package com.yangxingyu.xingyulab.content.tag.vo;

import lombok.Data;

@Data
public class TagVO {
    private Long id;
    private String tagName;
    private String slug;
    private String color;
    private Integer articleCount;
}
