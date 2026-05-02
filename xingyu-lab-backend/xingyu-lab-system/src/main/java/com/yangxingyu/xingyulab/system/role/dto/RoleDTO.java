package com.yangxingyu.xingyulab.system.role.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoleDTO {
    private Long id;
    @NotBlank(message = "角色名不能为空")
    private String roleName;
    @NotBlank(message = "角色标识不能为空")
    private String roleKey;
    private Integer roleSort;
    private Integer status;
    private String remark;
}
