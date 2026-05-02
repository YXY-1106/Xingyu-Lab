package com.yangxingyu.xingyulab.media.file.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FileVO {
    private Long id;
    private String originalName;
    private String fileName;
    private String url;
    private Long fileSize;
    private String mimeType;
    private String storageType;
    private LocalDateTime createTime;
}
