package com.yangxingyu.xingyulab.system.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    @NotBlank(message = "用户名不能为空")
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
