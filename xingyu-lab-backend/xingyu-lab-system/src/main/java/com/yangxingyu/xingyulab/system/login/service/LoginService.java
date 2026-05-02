package com.yangxingyu.xingyulab.system.login.service;

import com.yangxingyu.xingyulab.system.login.dto.LoginDTO;
import com.yangxingyu.xingyulab.system.login.vo.LoginVO;

public interface LoginService {
    LoginVO login(LoginDTO dto);
    void logout();
    LoginVO getCurrentUser();
}
