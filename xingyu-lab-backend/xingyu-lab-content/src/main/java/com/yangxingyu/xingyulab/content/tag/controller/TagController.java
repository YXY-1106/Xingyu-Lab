package com.yangxingyu.xingyulab.content.tag.controller;

import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.content.tag.dto.TagDTO;
import com.yangxingyu.xingyulab.content.tag.service.TagService;
import com.yangxingyu.xingyulab.content.tag.vo.TagVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "标签管理")
@RestController
@RequestMapping("/api/content/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @Operation(summary = "查询标签列表")
    @GetMapping("/list")
    public R<List<TagVO>> list() {
        return R.ok(tagService.listAll());
    }

    @Operation(summary = "新增标签")
    @PostMapping
    public R<Void> add(@Valid @RequestBody TagDTO dto) {
        tagService.addTag(dto);
        return R.ok();
    }

    @Operation(summary = "修改标签")
    @PutMapping
    public R<Void> update(@Valid @RequestBody TagDTO dto) {
        tagService.updateTag(dto);
        return R.ok();
    }

    @Operation(summary = "删除标签")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        tagService.deleteTag(id);
        return R.ok();
    }
}
