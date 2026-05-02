package com.yangxingyu.xingyulab.system.login.controller;

import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.system.login.dto.LoginDTO;
import com.yangxingyu.xingyulab.system.login.service.LoginService;
import com.yangxingyu.xingyulab.system.login.vo.LoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "登录认证")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public R<LoginVO> login(@Valid @RequestBody LoginDTO dto) {
        return R.ok(loginService.login(dto));
    }

    @Operation(summary = "用户登出")
    @PostMapping("/logout")
    public R<Void> logout() {
        loginService.logout();
        return R.ok();
    }

    @Operation(summary = "获取当前用户信息")
    @GetMapping("/info")
    public R<LoginVO> info() {
        return R.ok(loginService.getCurrentUser());
    }
}
