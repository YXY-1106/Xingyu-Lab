package com.yangxingyu.xingyulab.media.photo.controller;

import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.media.photo.dto.PhotoDTO;
import com.yangxingyu.xingyulab.media.photo.service.PhotoService;
import com.yangxingyu.xingyulab.media.photo.vo.PhotoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "照片墙")
@RestController
@RequestMapping("/api/media/photo")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @Operation(summary = "分页查询照片")
    @GetMapping("/list")
    public R<PageResult<PhotoVO>> list(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "20") int pageSize,
            @RequestParam(required = false) Long albumId) {
        return R.ok(photoService.pageList(pageNum, pageSize, albumId));
    }

    @Operation(summary = "新增照片")
    @PostMapping
    public R<Void> add(@Valid @RequestBody PhotoDTO dto) {
        photoService.addPhoto(dto);
        return R.ok();
    }

    @Operation(summary = "修改照片")
    @PutMapping
    public R<Void> update(@Valid @RequestBody PhotoDTO dto) {
        photoService.updatePhoto(dto);
        return R.ok();
    }

    @Operation(summary = "删除照片")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        photoService.deletePhoto(id);
        return R.ok();
    }
}
