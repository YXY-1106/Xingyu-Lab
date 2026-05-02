package com.yangxingyu.xingyulab.content.diary.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.content.diary.dto.DiaryDTO;
import com.yangxingyu.xingyulab.content.diary.entity.Diary;
import com.yangxingyu.xingyulab.content.diary.vo.DiaryVO;

public interface DiaryService extends IService<Diary> {
    PageResult<DiaryVO> pageList(int pageNum, int pageSize);
    void addDiary(DiaryDTO dto);
    void updateDiary(DiaryDTO dto);
    void deleteDiary(Long id);
}
