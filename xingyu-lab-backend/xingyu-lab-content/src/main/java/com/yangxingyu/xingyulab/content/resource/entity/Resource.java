package com.yangxingyu.xingyulab.content.resource.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("content_resource")
public class Resource extends BaseEntity {
    private String title;
    private String description;
    private String url;
    private String category;
    private String icon;
    private Integer sortOrder;
    private Integer status;
}
