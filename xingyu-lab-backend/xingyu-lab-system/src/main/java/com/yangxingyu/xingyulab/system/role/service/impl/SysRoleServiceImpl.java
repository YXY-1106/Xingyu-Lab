package com.yangxingyu.xingyulab.system.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.system.role.dto.RoleDTO;
import com.yangxingyu.xingyulab.system.role.entity.SysRole;
import com.yangxingyu.xingyulab.system.role.mapper.SysRoleMapper;
import com.yangxingyu.xingyulab.system.role.service.SysRoleService;
import com.yangxingyu.xingyulab.system.role.vo.RoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public List<RoleVO> listAll() {
        return this.list().stream().map(this::toVO).toList();
    }

    @Override
    public void addRole(RoleDTO dto) {
        SysRole role = new SysRole();
        BeanUtils.copyProperties(dto, role);
        this.save(role);
    }

    @Override
    public void updateRole(RoleDTO dto) {
        SysRole role = new SysRole();
        BeanUtils.copyProperties(dto, role);
        this.updateById(role);
    }

    @Override
    public void deleteRole(Long id) {
        this.removeById(id);
    }

    private RoleVO toVO(SysRole role) {
        RoleVO vo = new RoleVO();
        BeanUtils.copyProperties(role, vo);
        return vo;
    }
}
