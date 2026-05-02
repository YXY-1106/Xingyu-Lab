package com.yangxingyu.xingyulab.ai.chat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangxingyu.xingyulab.ai.chat.entity.AiMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AiMessageMapper extends BaseMapper<AiMessage> {
}
