package com.yangxingyu.xingyulab.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class SysUser extends BaseEntity {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String avatar;
    private Integer gender;
    private Integer status;
    private Long deptId;
    private String remark;
}
