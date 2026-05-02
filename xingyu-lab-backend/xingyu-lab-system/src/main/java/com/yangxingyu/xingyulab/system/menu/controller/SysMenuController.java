package com.yangxingyu.xingyulab.system.menu.controller;

import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.system.menu.dto.MenuDTO;
import com.yangxingyu.xingyulab.system.menu.service.SysMenuService;
import com.yangxingyu.xingyulab.system.menu.vo.MenuVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "菜单管理")
@RestController
@RequestMapping("/api/system/menu")
@RequiredArgsConstructor
public class SysMenuController {

    private final SysMenuService menuService;

    @Operation(summary = "查询菜单树")
    @GetMapping("/tree")
    public R<List<MenuVO>> tree() {
        return R.ok(menuService.treeList());
    }

    @Operation(summary = "新增菜单")
    @PostMapping
    public R<Void> add(@Valid @RequestBody MenuDTO dto) {
        menuService.addMenu(dto);
        return R.ok();
    }

    @Operation(summary = "修改菜单")
    @PutMapping
    public R<Void> update(@Valid @RequestBody MenuDTO dto) {
        menuService.updateMenu(dto);
        return R.ok();
    }

    @Operation(summary = "删除菜单")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return R.ok();
    }
}
