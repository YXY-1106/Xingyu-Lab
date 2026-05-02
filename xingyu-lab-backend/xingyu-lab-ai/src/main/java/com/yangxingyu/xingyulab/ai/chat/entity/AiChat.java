package com.yangxingyu.xingyulab.ai.chat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ai_chat")
public class AiChat extends BaseEntity {
    private Long userId;
    private String title;
    private String modelName;
    private Integer status;
}
