package com.yangxingyu.xingyulab.content.diary.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DiaryVO {
    private Long id;
    private String content;
    private String mood;
    private String weather;
    private Integer status;
    private Integer likeCount;
    private LocalDateTime createTime;
}
