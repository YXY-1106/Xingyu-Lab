package com.yangxingyu.xingyulab.content.tag.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.content.tag.dto.TagDTO;
import com.yangxingyu.xingyulab.content.tag.entity.Tag;
import com.yangxingyu.xingyulab.content.tag.mapper.TagMapper;
import com.yangxingyu.xingyulab.content.tag.service.TagService;
import com.yangxingyu.xingyulab.content.tag.vo.TagVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Override
    public List<TagVO> listAll() {
        return this.list().stream().map(this::toVO).toList();
    }

    @Override
    public void addTag(TagDTO dto) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(dto, tag);
        this.save(tag);
    }

    @Override
    public void updateTag(TagDTO dto) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(dto, tag);
        this.updateById(tag);
    }

    @Override
    public void deleteTag(Long id) {
        this.removeById(id);
    }

    private TagVO toVO(Tag tag) {
        TagVO vo = new TagVO();
        BeanUtils.copyProperties(tag, vo);
        return vo;
    }
}
