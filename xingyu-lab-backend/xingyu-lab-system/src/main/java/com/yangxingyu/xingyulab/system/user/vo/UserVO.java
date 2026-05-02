package com.yangxingyu.xingyulab.system.user.vo;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserVO {
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private String avatar;
    private Integer gender;
    private Integer status;
    private LocalDateTime createTime;
    private List<String> roles;
}
