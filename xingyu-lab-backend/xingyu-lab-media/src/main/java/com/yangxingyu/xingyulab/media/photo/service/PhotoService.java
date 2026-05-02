package com.yangxingyu.xingyulab.media.photo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.media.photo.dto.PhotoDTO;
import com.yangxingyu.xingyulab.media.photo.entity.Photo;
import com.yangxingyu.xingyulab.media.photo.vo.PhotoVO;

public interface PhotoService extends IService<Photo> {
    PageResult<PhotoVO> pageList(int pageNum, int pageSize, Long albumId);
    void addPhoto(PhotoDTO dto);
    void updatePhoto(PhotoDTO dto);
    void deletePhoto(Long id);
}
