package com.yangxingyu.xingyulab.system.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.common.exception.BusinessException;
import com.yangxingyu.xingyulab.common.exception.ErrorCode;
import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.system.user.dto.UserDTO;
import com.yangxingyu.xingyulab.system.user.entity.SysUser;
import com.yangxingyu.xingyulab.system.user.mapper.SysUserMapper;
import com.yangxingyu.xingyulab.system.user.service.SysUserService;
import com.yangxingyu.xingyulab.system.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public PageResult<UserVO> pageList(int pageNum, int pageSize, String username) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasText(username), SysUser::getUsername, username);
        wrapper.orderByDesc(SysUser::getCreateTime);
        Page<SysUser> page = this.page(new Page<>(pageNum, pageSize), wrapper);
        return new PageResult<>(page.getTotal(), page.getRecords().stream().map(this::toVO).toList());
    }

    @Override
    public UserVO getUserById(Long id) {
        SysUser user = this.getById(id);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }
        return toVO(user);
    }

    @Override
    public void addUser(UserDTO dto) {
        SysUser user = new SysUser();
        BeanUtils.copyProperties(dto, user);
        this.save(user);
    }

    @Override
    public void updateUser(UserDTO dto) {
        SysUser user = new SysUser();
        BeanUtils.copyProperties(dto, user);
        this.updateById(user);
    }

    @Override
    public void deleteUser(Long id) {
        this.removeById(id);
    }

    private UserVO toVO(SysUser user) {
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(user, vo);
        return vo;
    }
}
