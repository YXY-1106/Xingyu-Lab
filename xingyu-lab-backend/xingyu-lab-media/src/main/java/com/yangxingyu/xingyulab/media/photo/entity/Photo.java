package com.yangxingyu.xingyulab.media.photo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("media_photo")
public class Photo extends BaseEntity {
    private String title;
    private String description;
    private String url;
    private String thumbnailUrl;
    private Long albumId;
    private Integer sortOrder;
    private Integer likeCount;
    private Integer status;
}
