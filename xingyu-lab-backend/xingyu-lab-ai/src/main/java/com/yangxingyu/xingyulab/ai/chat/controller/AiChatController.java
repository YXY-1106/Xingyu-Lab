package com.yangxingyu.xingyulab.ai.chat.controller;

import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.ai.chat.dto.ChatDTO;
import com.yangxingyu.xingyulab.ai.chat.service.AiChatService;
import com.yangxingyu.xingyulab.ai.chat.vo.ChatVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "AI 对话")
@RestController
@RequestMapping("/api/ai/chat")
@RequiredArgsConstructor
public class AiChatController {

    private final AiChatService aiChatService;

    @Operation(summary = "发送消息")
    @PostMapping
    public R<ChatVO> chat(@Valid @RequestBody ChatDTO dto) {
        return R.ok(aiChatService.chat(dto));
    }
}
