package com.yangxingyu.xingyulab.system.menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.system.menu.dto.MenuDTO;
import com.yangxingyu.xingyulab.system.menu.entity.SysMenu;
import com.yangxingyu.xingyulab.system.menu.vo.MenuVO;
import java.util.List;

public interface SysMenuService extends IService<SysMenu> {
    List<MenuVO> treeList();
    void addMenu(MenuDTO dto);
    void updateMenu(MenuDTO dto);
    void deleteMenu(Long id);
}
