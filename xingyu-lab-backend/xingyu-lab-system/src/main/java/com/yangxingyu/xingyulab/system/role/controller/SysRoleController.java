package com.yangxingyu.xingyulab.system.role.controller;

import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.system.role.dto.RoleDTO;
import com.yangxingyu.xingyulab.system.role.service.SysRoleService;
import com.yangxingyu.xingyulab.system.role.vo.RoleVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "角色管理")
@RestController
@RequestMapping("/api/system/role")
@RequiredArgsConstructor
public class SysRoleController {

    private final SysRoleService roleService;

    @Operation(summary = "查询角色列表")
    @GetMapping("/list")
    public R<List<RoleVO>> list() {
        return R.ok(roleService.listAll());
    }

    @Operation(summary = "新增角色")
    @PostMapping
    public R<Void> add(@Valid @RequestBody RoleDTO dto) {
        roleService.addRole(dto);
        return R.ok();
    }

    @Operation(summary = "修改角色")
    @PutMapping
    public R<Void> update(@Valid @RequestBody RoleDTO dto) {
        roleService.updateRole(dto);
        return R.ok();
    }

    @Operation(summary = "删除角色")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        roleService.deleteRole(id);
        return R.ok();
    }
}
