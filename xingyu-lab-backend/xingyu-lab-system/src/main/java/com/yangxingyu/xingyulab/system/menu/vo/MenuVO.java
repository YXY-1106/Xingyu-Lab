package com.yangxingyu.xingyulab.system.menu.vo;

import lombok.Data;
import java.util.List;

@Data
public class MenuVO {
    private Long id;
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
    private List<MenuVO> children;
}
