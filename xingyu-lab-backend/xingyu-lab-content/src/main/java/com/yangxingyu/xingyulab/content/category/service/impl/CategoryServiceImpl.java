package com.yangxingyu.xingyulab.content.category.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.content.category.dto.CategoryDTO;
import com.yangxingyu.xingyulab.content.category.entity.Category;
import com.yangxingyu.xingyulab.content.category.mapper.CategoryMapper;
import com.yangxingyu.xingyulab.content.category.service.CategoryService;
import com.yangxingyu.xingyulab.content.category.vo.CategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public List<CategoryVO> listAll() {
        return this.list().stream().map(this::toVO).toList();
    }

    @Override
    public void addCategory(CategoryDTO dto) {
        Category category = new Category();
        BeanUtils.copyProperties(dto, category);
        this.save(category);
    }

    @Override
    public void updateCategory(CategoryDTO dto) {
        Category category = new Category();
        BeanUtils.copyProperties(dto, category);
        this.updateById(category);
    }

    @Override
    public void deleteCategory(Long id) {
        this.removeById(id);
    }

    private CategoryVO toVO(Category category) {
        CategoryVO vo = new CategoryVO();
        BeanUtils.copyProperties(category, vo);
        return vo;
    }
}
