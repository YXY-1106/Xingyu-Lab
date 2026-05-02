package com.yangxingyu.xingyulab.content.category.controller;

import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.content.category.dto.CategoryDTO;
import com.yangxingyu.xingyulab.content.category.service.CategoryService;
import com.yangxingyu.xingyulab.content.category.vo.CategoryVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "分类管理")
@RestController
@RequestMapping("/api/content/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "查询分类列表")
    @GetMapping("/list")
    public R<List<CategoryVO>> list() {
        return R.ok(categoryService.listAll());
    }

    @Operation(summary = "新增分类")
    @PostMapping
    public R<Void> add(@Valid @RequestBody CategoryDTO dto) {
        categoryService.addCategory(dto);
        return R.ok();
    }

    @Operation(summary = "修改分类")
    @PutMapping
    public R<Void> update(@Valid @RequestBody CategoryDTO dto) {
        categoryService.updateCategory(dto);
        return R.ok();
    }

    @Operation(summary = "删除分类")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return R.ok();
    }
}
