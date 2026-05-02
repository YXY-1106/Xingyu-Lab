package com.yangxingyu.xingyulab.content.diary.controller;

import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.content.diary.dto.DiaryDTO;
import com.yangxingyu.xingyulab.content.diary.service.DiaryService;
import com.yangxingyu.xingyulab.content.diary.vo.DiaryVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "日记管理")
@RestController
@RequestMapping("/api/content/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @Operation(summary = "分页查询日记")
    @GetMapping("/list")
    public R<PageResult<DiaryVO>> list(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        return R.ok(diaryService.pageList(pageNum, pageSize));
    }

    @Operation(summary = "新增日记")
    @PostMapping
    public R<Void> add(@Valid @RequestBody DiaryDTO dto) {
        diaryService.addDiary(dto);
        return R.ok();
    }

    @Operation(summary = "修改日记")
    @PutMapping
    public R<Void> update(@Valid @RequestBody DiaryDTO dto) {
        diaryService.updateDiary(dto);
        return R.ok();
    }

    @Operation(summary = "删除日记")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        diaryService.deleteDiary(id);
        return R.ok();
    }
}
