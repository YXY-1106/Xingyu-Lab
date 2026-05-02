package com.yangxingyu.xingyulab.system.dict.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.system.dict.dto.DictDTO;
import com.yangxingyu.xingyulab.system.dict.entity.SysDict;
import com.yangxingyu.xingyulab.system.dict.entity.SysDictData;
import com.yangxingyu.xingyulab.system.dict.mapper.SysDictDataMapper;
import com.yangxingyu.xingyulab.system.dict.mapper.SysDictMapper;
import com.yangxingyu.xingyulab.system.dict.service.SysDictService;
import com.yangxingyu.xingyulab.system.dict.vo.DictVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    private final SysDictDataMapper dictDataMapper;

    @Override
    public List<DictVO> listAll() {
        return this.list().stream().map(dict -> {
            DictVO vo = new DictVO();
            BeanUtils.copyProperties(dict, vo);
            List<SysDictData> dataList = dictDataMapper.selectList(
                    new LambdaQueryWrapper<SysDictData>().eq(SysDictData::getDictType, dict.getDictType()));
            vo.setDataList(dataList);
            return vo;
        }).toList();
    }

    @Override
    public void addDict(DictDTO dto) {
        SysDict dict = new SysDict();
        BeanUtils.copyProperties(dto, dict);
        this.save(dict);
    }

    @Override
    public void updateDict(DictDTO dto) {
        SysDict dict = new SysDict();
        BeanUtils.copyProperties(dto, dict);
        this.updateById(dict);
    }

    @Override
    public void deleteDict(Long id) {
        this.removeById(id);
    }
}
