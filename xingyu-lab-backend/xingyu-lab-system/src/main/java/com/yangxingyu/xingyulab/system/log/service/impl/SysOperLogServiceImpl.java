package com.yangxingyu.xingyulab.system.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.system.log.entity.SysOperLog;
import com.yangxingyu.xingyulab.system.log.mapper.SysOperLogMapper;
import com.yangxingyu.xingyulab.system.log.service.SysOperLogService;
import org.springframework.stereotype.Service;

@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements SysOperLogService {
}
