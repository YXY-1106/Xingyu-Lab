package com.yangxingyu.xingyulab.media.photo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.media.photo.dto.PhotoDTO;
import com.yangxingyu.xingyulab.media.photo.entity.Photo;
import com.yangxingyu.xingyulab.media.photo.mapper.PhotoMapper;
import com.yangxingyu.xingyulab.media.photo.service.PhotoService;
import com.yangxingyu.xingyulab.media.photo.vo.PhotoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo> implements PhotoService {

    @Override
    public PageResult<PhotoVO> pageList(int pageNum, int pageSize, Long albumId) {
        LambdaQueryWrapper<Photo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(albumId != null, Photo::getAlbumId, albumId);
        wrapper.eq(Photo::getStatus, 0);
        wrapper.orderByAsc(Photo::getSortOrder).orderByDesc(Photo::getCreateTime);
        Page<Photo> page = this.page(new Page<>(pageNum, pageSize), wrapper);
        return new PageResult<>(page.getTotal(), page.getRecords().stream().map(this::toVO).toList());
    }

    @Override
    public void addPhoto(PhotoDTO dto) {
        Photo photo = new Photo();
        BeanUtils.copyProperties(dto, photo);
        photo.setLikeCount(0);
        this.save(photo);
    }

    @Override
    public void updatePhoto(PhotoDTO dto) {
        Photo photo = new Photo();
        BeanUtils.copyProperties(dto, photo);
        this.updateById(photo);
    }

    @Override
    public void deletePhoto(Long id) {
        this.removeById(id);
    }

    private PhotoVO toVO(Photo photo) {
        PhotoVO vo = new PhotoVO();
        BeanUtils.copyProperties(photo, vo);
        return vo;
    }
}
