package com.yangxingyu.xingyulab.media.photo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PhotoDTO {
    private Long id;
    private String title;
    private String description;
    @NotBlank(message = "图片URL不能为空")
    private String url;
    private String thumbnailUrl;
    private Long albumId;
    private Integer sortOrder;
    private Integer status;
}
