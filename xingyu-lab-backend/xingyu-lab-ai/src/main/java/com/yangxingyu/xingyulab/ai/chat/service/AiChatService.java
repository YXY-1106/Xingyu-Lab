package com.yangxingyu.xingyulab.ai.chat.service;

import com.yangxingyu.xingyulab.ai.chat.dto.ChatDTO;
import com.yangxingyu.xingyulab.ai.chat.vo.ChatVO;

public interface AiChatService {
    ChatVO chat(ChatDTO dto);
}
