package com.yangxingyu.xingyulab.media.file.controller;

import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.media.file.service.FileService;
import com.yangxingyu.xingyulab.media.file.vo.FileVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "文件管理")
@RestController
@RequestMapping("/api/media/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @Operation(summary = "文件上传")
    @PostMapping("/upload")
    public R<FileVO> upload(@RequestParam("file") MultipartFile file) {
        return R.ok(fileService.upload(file));
    }

    @Operation(summary = "分页查询文件")
    @GetMapping("/page")
    public R<PageResult<FileVO>> page(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "20") int pageSize,
            @RequestParam(required = false) String mimeType) {
        return R.ok(fileService.pageList(pageNum, pageSize, mimeType));
    }

    @Operation(summary = "删除文件")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        fileService.deleteFile(id);
        return R.ok();
    }
}
