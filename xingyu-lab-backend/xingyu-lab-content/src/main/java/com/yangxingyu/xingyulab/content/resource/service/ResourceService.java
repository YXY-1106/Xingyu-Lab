package com.yangxingyu.xingyulab.content.resource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.content.resource.dto.ResourceDTO;
import com.yangxingyu.xingyulab.content.resource.entity.Resource;
import com.yangxingyu.xingyulab.content.resource.vo.ResourceVO;
import java.util.List;

public interface ResourceService extends IService<Resource> {
    List<ResourceVO> listByCategory(String category);
    void addResource(ResourceDTO dto);
    void updateResource(ResourceDTO dto);
    void deleteResource(Long id);
}
