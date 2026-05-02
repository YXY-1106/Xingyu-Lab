package com.yangxingyu.xingyulab.system.login.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yangxingyu.xingyulab.common.exception.BusinessException;
import com.yangxingyu.xingyulab.common.exception.ErrorCode;
import com.yangxingyu.xingyulab.system.login.dto.LoginDTO;
import com.yangxingyu.xingyulab.system.login.service.LoginService;
import com.yangxingyu.xingyulab.system.login.vo.LoginVO;
import com.yangxingyu.xingyulab.system.user.entity.SysUser;
import com.yangxingyu.xingyulab.system.user.mapper.SysUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final SysUserMapper userMapper;

    @Override
    public LoginVO login(LoginDTO dto) {
        SysUser user = userMapper.selectOne(
                new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, dto.getUsername()));
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }
        if (!dto.getPassword().equals(user.getPassword())) {
            throw new BusinessException(ErrorCode.USER_PASSWORD_ERROR);
        }
        StpUtil.login(user.getId());
        return LoginVO.builder()
                .token(StpUtil.getTokenValue())
                .userId(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .avatar(user.getAvatar())
                .build();
    }

    @Override
    public void logout() {
        StpUtil.logout();
    }

    @Override
    public LoginVO getCurrentUser() {
        long userId = StpUtil.getLoginIdAsLong();
        SysUser user = userMapper.selectById(userId);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }
        return LoginVO.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .avatar(user.getAvatar())
                .build();
    }
}
