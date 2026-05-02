package com.yangxingyu.xingyulab.content.resource.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ResourceDTO {
    private Long id;
    @NotBlank(message = "标题不能为空")
    private String title;
    private String description;
    @NotBlank(message = "链接不能为空")
    private String url;
    private String category;
    private String icon;
    private Integer sortOrder;
    private Integer status;
}
