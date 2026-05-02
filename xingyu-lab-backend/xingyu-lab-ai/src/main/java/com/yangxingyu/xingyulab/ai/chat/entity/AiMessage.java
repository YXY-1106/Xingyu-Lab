package com.yangxingyu.xingyulab.ai.chat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ai_message")
public class AiMessage extends BaseEntity {
    private Long chatId;
    private String role;    // user / assistant / system
    private String content;
    private String modelName;
    private Integer tokenCount;
}
