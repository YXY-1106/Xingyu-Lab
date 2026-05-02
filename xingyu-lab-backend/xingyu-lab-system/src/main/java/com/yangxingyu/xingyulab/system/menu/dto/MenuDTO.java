package com.yangxingyu.xingyulab.system.menu.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MenuDTO {
    private Long id;
    @NotBlank(message = "菜单名称不能为空")
    private String menuName;
    private Long parentId;
    private Integer orderNum;
    private String path;
    private String component;
    private Integer menuType;
    private Integer visible;
    private Integer status;
    private String perms;
    private String icon;
    private String remark;
}
