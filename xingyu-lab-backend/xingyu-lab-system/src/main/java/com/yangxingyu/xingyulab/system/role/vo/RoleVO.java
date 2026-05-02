package com.yangxingyu.xingyulab.system.role.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RoleVO {
    private Long id;
    private String roleName;
    private String roleKey;
    private Integer roleSort;
    private Integer status;
    private String remark;
    private LocalDateTime createTime;
}
