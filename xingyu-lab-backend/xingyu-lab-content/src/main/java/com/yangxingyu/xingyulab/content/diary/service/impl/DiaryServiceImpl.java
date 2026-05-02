package com.yangxingyu.xingyulab.content.diary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.content.diary.dto.DiaryDTO;
import com.yangxingyu.xingyulab.content.diary.entity.Diary;
import com.yangxingyu.xingyulab.content.diary.mapper.DiaryMapper;
import com.yangxingyu.xingyulab.content.diary.service.DiaryService;
import com.yangxingyu.xingyulab.content.diary.vo.DiaryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, Diary> implements DiaryService {

    @Override
    public PageResult<DiaryVO> pageList(int pageNum, int pageSize) {
        LambdaQueryWrapper<Diary> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Diary::getCreateTime);
        Page<Diary> page = this.page(new Page<>(pageNum, pageSize), wrapper);
        return new PageResult<>(page.getTotal(), page.getRecords().stream().map(this::toVO).toList());
    }

    @Override
    public void addDiary(DiaryDTO dto) {
        Diary diary = new Diary();
        BeanUtils.copyProperties(dto, diary);
        diary.setLikeCount(0);
        this.save(diary);
    }

    @Override
    public void updateDiary(DiaryDTO dto) {
        Diary diary = new Diary();
        BeanUtils.copyProperties(dto, diary);
        this.updateById(diary);
    }

    @Override
    public void deleteDiary(Long id) {
        this.removeById(id);
    }

    private DiaryVO toVO(Diary diary) {
        DiaryVO vo = new DiaryVO();
        BeanUtils.copyProperties(diary, vo);
        return vo;
    }
}
