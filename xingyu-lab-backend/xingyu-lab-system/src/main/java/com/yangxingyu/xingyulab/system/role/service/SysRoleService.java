package com.yangxingyu.xingyulab.system.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.system.role.dto.RoleDTO;
import com.yangxingyu.xingyulab.system.role.entity.SysRole;
import com.yangxingyu.xingyulab.system.role.vo.RoleVO;
import java.util.List;

public interface SysRoleService extends IService<SysRole> {
    List<RoleVO> listAll();
    void addRole(RoleDTO dto);
    void updateRole(RoleDTO dto);
    void deleteRole(Long id);
}
