package com.yangxingyu.xingyulab.content.category.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.content.category.dto.CategoryDTO;
import com.yangxingyu.xingyulab.content.category.entity.Category;
import com.yangxingyu.xingyulab.content.category.vo.CategoryVO;
import java.util.List;

public interface CategoryService extends IService<Category> {
    List<CategoryVO> listAll();
    void addCategory(CategoryDTO dto);
    void updateCategory(CategoryDTO dto);
    void deleteCategory(Long id);
}
