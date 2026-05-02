package com.yangxingyu.xingyulab.content.tag.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.content.tag.dto.TagDTO;
import com.yangxingyu.xingyulab.content.tag.entity.Tag;
import com.yangxingyu.xingyulab.content.tag.vo.TagVO;
import java.util.List;

public interface TagService extends IService<Tag> {
    List<TagVO> listAll();
    void addTag(TagDTO dto);
    void updateTag(TagDTO dto);
    void deleteTag(Long id);
}
