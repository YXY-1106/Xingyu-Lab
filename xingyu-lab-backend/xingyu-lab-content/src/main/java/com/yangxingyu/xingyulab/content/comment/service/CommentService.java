package com.yangxingyu.xingyulab.content.comment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.content.comment.dto.CommentDTO;
import com.yangxingyu.xingyulab.content.comment.entity.Comment;
import com.yangxingyu.xingyulab.content.comment.vo.CommentVO;
import java.util.List;

public interface CommentService extends IService<Comment> {
    List<CommentVO> listByArticle(Long articleId);
    void addComment(CommentDTO dto);
    void deleteComment(Long id);
}
