package com.yangxingyu.xingyulab.content.tag.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TagDTO {
    private Long id;
    @NotBlank(message = "标签名称不能为空")
    private String tagName;
    private String slug;
    private String color;
    private Integer status;
}
