package com.yangxingyu.xingyulab.system.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("sys_oper_log")
public class SysOperLog {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String module;
    private String businessType;
    private String method;
    private String requestMethod;
    private String requestUrl;
    private String requestParam;
    private String responseResult;
    private Integer status;
    private String errorMsg;
    private Long operUserId;
    private String operIp;
    private LocalDateTime operTime;
}
