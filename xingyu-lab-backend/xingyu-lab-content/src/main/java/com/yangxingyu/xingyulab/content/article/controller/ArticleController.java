package com.yangxingyu.xingyulab.content.article.controller;

import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.content.article.dto.ArticleDTO;
import com.yangxingyu.xingyulab.content.article.service.ArticleService;
import com.yangxingyu.xingyulab.content.article.vo.ArticleListVO;
import com.yangxingyu.xingyulab.content.article.vo.ArticleVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "文章管理")
@RestController
@RequestMapping("/api/content/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @Operation(summary = "分页查询文章列表")
    @GetMapping("/list")
    public R<PageResult<ArticleListVO>> list(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String keyword) {
        return R.ok(articleService.pageList(pageNum, pageSize, categoryId, keyword));
    }

    @Operation(summary = "文章详情")
    @GetMapping("/detail/{id}")
    public R<ArticleVO> detail(@PathVariable Long id) {
        return R.ok(articleService.getDetail(id));
    }

    @Operation(summary = "新增文章")
    @PostMapping
    public R<Void> add(@Valid @RequestBody ArticleDTO dto) {
        articleService.addArticle(dto);
        return R.ok();
    }

    @Operation(summary = "修改文章")
    @PutMapping
    public R<Void> update(@Valid @RequestBody ArticleDTO dto) {
        articleService.updateArticle(dto);
        return R.ok();
    }

    @Operation(summary = "删除文章")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return R.ok();
    }

    @Operation(summary = "发布文章")
    @PutMapping("/publish/{id}")
    public R<Void> publish(@PathVariable Long id) {
        articleService.publish(id);
        return R.ok();
    }
}
