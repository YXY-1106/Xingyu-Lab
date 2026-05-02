package com.yangxingyu.xingyulab.media.file.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_file")
public class SysFile extends BaseEntity {
    private String originalName;
    private String fileName;
    private String filePath;
    private String url;
    private Long fileSize;
    private String mimeType;
    private String storageType;  // local / oss / minio
    private Integer status;
}
