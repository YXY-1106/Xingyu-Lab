package com.yangxingyu.xingyulab.content.resource.controller;

import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.content.resource.dto.ResourceDTO;
import com.yangxingyu.xingyulab.content.resource.service.ResourceService;
import com.yangxingyu.xingyulab.content.resource.vo.ResourceVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "资料库管理")
@RestController
@RequestMapping("/api/content/resource")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    @Operation(summary = "查询资料列表")
    @GetMapping("/list")
    public R<List<ResourceVO>> list(@RequestParam(required = false) String category) {
        return R.ok(resourceService.listByCategory(category));
    }

    @Operation(summary = "新增资料")
    @PostMapping
    public R<Void> add(@Valid @RequestBody ResourceDTO dto) {
        resourceService.addResource(dto);
        return R.ok();
    }

    @Operation(summary = "修改资料")
    @PutMapping
    public R<Void> update(@Valid @RequestBody ResourceDTO dto) {
        resourceService.updateResource(dto);
        return R.ok();
    }

    @Operation(summary = "删除资料")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return R.ok();
    }
}
