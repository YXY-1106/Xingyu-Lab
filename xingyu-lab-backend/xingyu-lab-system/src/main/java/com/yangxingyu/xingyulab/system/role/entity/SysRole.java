package com.yangxingyu.xingyulab.system.role.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
public class SysRole extends BaseEntity {
    private String roleName;
    private String roleKey;
    private Integer roleSort;
    private Integer status;
    private String remark;
}
