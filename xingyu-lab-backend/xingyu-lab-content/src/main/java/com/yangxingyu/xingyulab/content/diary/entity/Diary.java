package com.yangxingyu.xingyulab.content.diary.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("content_diary")
public class Diary extends BaseEntity {
    private String content;
    private String mood;
    private String weather;
    private Integer status;
    private Integer likeCount;
}
