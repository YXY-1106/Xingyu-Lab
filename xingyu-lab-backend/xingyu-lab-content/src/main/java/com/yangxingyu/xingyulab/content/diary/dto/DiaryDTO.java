package com.yangxingyu.xingyulab.content.diary.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DiaryDTO {
    private Long id;
    @NotBlank(message = "日记内容不能为空")
    private String content;
    private String mood;
    private String weather;
    private Integer status;
}
