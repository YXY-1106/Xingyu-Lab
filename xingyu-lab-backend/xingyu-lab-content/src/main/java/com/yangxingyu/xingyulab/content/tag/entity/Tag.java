package com.yangxingyu.xingyulab.content.tag.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("content_tag")
public class Tag extends BaseEntity {
    private String tagName;
    private String slug;
    private String color;
    private Integer status;
}
