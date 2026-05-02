package com.yangxingyu.xingyulab.system.menu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxingyu.xingyulab.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
public class SysMenu extends BaseEntity {
    private String menuName;
    private Long parentId;
    private Integer orderNum;
    private String path;
    private String component;
    private Integer menuType;  // M目录 C菜单 F按钮
    private Integer visible;
    private Integer status;
    private String perms;
    private String icon;
    private String remark;
}
