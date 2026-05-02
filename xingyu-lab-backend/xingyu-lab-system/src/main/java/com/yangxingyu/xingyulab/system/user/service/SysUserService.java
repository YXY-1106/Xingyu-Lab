package com.yangxingyu.xingyulab.system.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.system.user.dto.UserDTO;
import com.yangxingyu.xingyulab.system.user.entity.SysUser;
import com.yangxingyu.xingyulab.system.user.vo.UserVO;

public interface SysUserService extends IService<SysUser> {
    PageResult<UserVO> pageList(int pageNum, int pageSize, String username);
    UserVO getUserById(Long id);
    void addUser(UserDTO dto);
    void updateUser(UserDTO dto);
    void deleteUser(Long id);
}
