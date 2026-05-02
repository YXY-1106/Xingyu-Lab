package com.yangxingyu.xingyulab.lab.shortlink.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lab_short_link")
public class ShortLink extends BaseEntity {
    private String shortCode;
    private String originalUrl;
    private Integer clickCount;
    private Integer status;
}
