package com.yangxingyu.xingyulab.ai.chat.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChatDTO {
    @NotBlank(message = "消息内容不能为空")
    private String content;
    private Long chatId;
    private String modelName;
}
