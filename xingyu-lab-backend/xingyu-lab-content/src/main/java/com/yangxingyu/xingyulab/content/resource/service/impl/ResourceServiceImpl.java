package com.yangxingyu.xingyulab.content.resource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.content.resource.dto.ResourceDTO;
import com.yangxingyu.xingyulab.content.resource.entity.Resource;
import com.yangxingyu.xingyulab.content.resource.mapper.ResourceMapper;
import com.yangxingyu.xingyulab.content.resource.service.ResourceService;
import com.yangxingyu.xingyulab.content.resource.vo.ResourceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;

@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Override
    public List<ResourceVO> listByCategory(String category) {
        LambdaQueryWrapper<Resource> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasText(category), Resource::getCategory, category);
        wrapper.eq(Resource::getStatus, 0);
        wrapper.orderByAsc(Resource::getSortOrder);
        return this.list(wrapper).stream().map(this::toVO).toList();
    }

    @Override
    public void addResource(ResourceDTO dto) {
        Resource resource = new Resource();
        BeanUtils.copyProperties(dto, resource);
        this.save(resource);
    }

    @Override
    public void updateResource(ResourceDTO dto) {
        Resource resource = new Resource();
        BeanUtils.copyProperties(dto, resource);
        this.updateById(resource);
    }

    @Override
    public void deleteResource(Long id) {
        this.removeById(id);
    }

    private ResourceVO toVO(Resource resource) {
        ResourceVO vo = new ResourceVO();
        BeanUtils.copyProperties(resource, vo);
        return vo;
    }
}
