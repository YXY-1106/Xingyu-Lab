package com.yangxingyu.xingyulab.content.comment.controller;

import com.yangxingyu.xingyulab.common.result.R;
import com.yangxingyu.xingyulab.content.comment.dto.CommentDTO;
import com.yangxingyu.xingyulab.content.comment.service.CommentService;
import com.yangxingyu.xingyulab.content.comment.vo.CommentVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "评论管理")
@RestController
@RequestMapping("/api/content/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @Operation(summary = "查询文章评论")
    @GetMapping("/list/{articleId}")
    public R<List<CommentVO>> list(@PathVariable Long articleId) {
        return R.ok(commentService.listByArticle(articleId));
    }

    @Operation(summary = "新增评论")
    @PostMapping
    public R<Void> add(@Valid @RequestBody CommentDTO dto) {
        commentService.addComment(dto);
        return R.ok();
    }

    @Operation(summary = "删除评论")
    @DeleteMapping("/{id}")
    public R<Void> delete(@PathVariable Long id) {
        commentService.deleteComment(id);
        return R.ok();
    }
}
