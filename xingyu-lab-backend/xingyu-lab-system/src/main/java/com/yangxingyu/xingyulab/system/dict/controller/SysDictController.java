package com.yangxingyu.xingyulab.system.dict.controller;

import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.system.dict.dto.DictDTO;
import com.yangxingyu.xingyulab.system.dict.service.SysDictService;
import com.yangxingyu.xingyulab.system.dict.vo.DictVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "字典管理")
@RestController
@RequestMapping("/api/system/dict")
@RequiredArgsConstructor
public class SysDictController {

    private final SysDictService dictService;

    @Operation(summary = "查询字典列表")
    @GetMapping("/list")
    public R<List<DictVO>> list() {
        return R.ok(dictService.listAll());
    }

    @Operation(summary = "新增字典")
    @PostMapping
    public R<Void> add(@Valid @RequestBody DictDTO dto) {
        dictService.addDict(dto);
        return R.ok();
    }

    @Operation(summary = "修改字典")
    @PutMapping
    public R<Void> update(@Valid @RequestBody DictDTO dto) {
        dictService.updateDict(dto);
        return R.ok();
    }

    @Operation(summary = "删除字典")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        dictService.deleteDict(id);
        return R.ok();
    }
}
