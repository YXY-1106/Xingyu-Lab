package com.yangxingyu.xingyulab.ai.chat.service.impl;

import com.yangxingyu.xingyulab.ai.chat.dto.ChatDTO;
import com.yangxingyu.xingyulab.ai.chat.service.AiChatService;
import com.yangxingyu.xingyulab.ai.chat.vo.ChatVO;
import org.springframework.stereotype.Service;

@Service
public class AiChatServiceImpl implements AiChatService {

    @Override
    public ChatVO chat(ChatDTO dto) {
        // TODO: 接入 MiMo / OpenAI 兼容接口
        return ChatVO.builder()
                .chatId(dto.getChatId())
                .role("assistant")
                .content("AI 模块待接入，请配置 API Key 后使用。")
                .modelName(dto.getModelName())
                .build();
    }
}
