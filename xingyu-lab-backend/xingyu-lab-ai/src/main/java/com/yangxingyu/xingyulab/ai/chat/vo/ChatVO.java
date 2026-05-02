package com.yangxingyu.xingyulab.ai.chat.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatVO {
    private Long chatId;
    private String role;
    private String content;
    private String modelName;
}
