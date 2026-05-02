package com.yangxingyu.xingyulab.system.dict.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.system.dict.dto.DictDTO;
import com.yangxingyu.xingyulab.system.dict.entity.SysDict;
import com.yangxingyu.xingyulab.system.dict.vo.DictVO;
import java.util.List;

public interface SysDictService extends IService<SysDict> {
    List<DictVO> listAll();
    void addDict(DictDTO dto);
    void updateDict(DictDTO dto);
    void deleteDict(Long id);
}
