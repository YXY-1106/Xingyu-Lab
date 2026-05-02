package com.yangxingyu.xingyulab.content.category.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    @NotBlank(message = "分类名称不能为空")
    private String categoryName;
    private String slug;
    private String description;
    private Integer sortOrder;
    private Integer status;
}
