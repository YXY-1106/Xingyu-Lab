package com.yangxingyu.xingyulab.system.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.system.menu.dto.MenuDTO;
import com.yangxingyu.xingyulab.system.menu.entity.SysMenu;
import com.yangxingyu.xingyulab.system.menu.mapper.SysMenuMapper;
import com.yangxingyu.xingyulab.system.menu.service.SysMenuService;
import com.yangxingyu.xingyulab.system.menu.vo.MenuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public List<MenuVO> treeList() {
        List<SysMenu> menus = this.list();
        List<MenuVO> voList = menus.stream().map(this::toVO).toList();
        return buildTree(voList, 0L);
    }

    @Override
    public void addMenu(MenuDTO dto) {
        SysMenu menu = new SysMenu();
        BeanUtils.copyProperties(dto, menu);
        this.save(menu);
    }

    @Override
    public void updateMenu(MenuDTO dto) {
        SysMenu menu = new SysMenu();
        BeanUtils.copyProperties(dto, menu);
        this.updateById(menu);
    }

    @Override
    public void deleteMenu(Long id) {
        this.removeById(id);
    }

    private MenuVO toVO(SysMenu menu) {
        MenuVO vo = new MenuVO();
        BeanUtils.copyProperties(menu, vo);
        return vo;
    }

    private List<MenuVO> buildTree(List<MenuVO> list, Long parentId) {
        Map<Long, List<MenuVO>> grouped = list.stream()
                .collect(Collectors.groupingBy(MenuVO::getParentId));
        List<MenuVO> tree = grouped.getOrDefault(parentId, new ArrayList<>());
        for (MenuVO node : tree) {
            node.setChildren(buildTree(list, node.getId()));
        }
        return tree;
    }
}
