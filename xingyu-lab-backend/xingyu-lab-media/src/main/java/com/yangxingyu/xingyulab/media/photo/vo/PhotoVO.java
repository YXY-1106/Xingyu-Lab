package com.yangxingyu.xingyulab.media.photo.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PhotoVO {
    private Long id;
    private String title;
    private String description;
    private String url;
    private String thumbnailUrl;
    private Long albumId;
    private Integer likeCount;
    private LocalDateTime createTime;
}
