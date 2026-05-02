package com.yangxingyu.xingyulab.content.category.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("content_category")
public class Category extends BaseEntity {
    private String categoryName;
    private String slug;
    private String description;
    private Integer sortOrder;
    private Integer status;
}
