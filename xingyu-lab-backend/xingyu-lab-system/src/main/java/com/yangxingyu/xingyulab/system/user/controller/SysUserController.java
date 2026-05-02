package com.yangxingyu.xingyulab.system.user.controller;

import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.system.user.dto.UserDTO;
import com.yangxingyu.xingyulab.system.user.service.SysUserService;
import com.yangxingyu.xingyulab.system.user.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户管理")
@RestController
@RequestMapping("/api/system/user")
@RequiredArgsConstructor
public class SysUserController {

    private final SysUserService userService;

    @Operation(summary = "分页查询用户")
    @GetMapping("/page")
    public R<PageResult<UserVO>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String username) {
        return R.ok(userService.pageList(pageNum, pageSize, username));
    }

    @Operation(summary = "根据ID查询用户")
    @GetMapping("/{id}")
    public R<UserVO> getById(@PathVariable Long id) {
        return R.ok(userService.getUserById(id));
    }

    @Operation(summary = "新增用户")
    @PostMapping
    public R<Void> add(@Valid @RequestBody UserDTO dto) {
        userService.addUser(dto);
        return R.ok();
    }

    @Operation(summary = "修改用户")
    @PutMapping
    public R<Void> update(@Valid @RequestBody UserDTO dto) {
        userService.updateUser(dto);
        return R.ok();
    }

    @Operation(summary = "删除用户")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return R.ok();
    }
}
