package com.yangxingyu.xingyulab.content.comment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.content.comment.dto.CommentDTO;
import com.yangxingyu.xingyulab.content.comment.entity.Comment;
import com.yangxingyu.xingyulab.content.comment.mapper.CommentMapper;
import com.yangxingyu.xingyulab.content.comment.service.CommentService;
import com.yangxingyu.xingyulab.content.comment.vo.CommentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public List<CommentVO> listByArticle(Long articleId) {
        List<Comment> comments = this.list(new LambdaQueryWrapper<Comment>()
                .eq(Comment::getArticleId, articleId)
                .eq(Comment::getStatus, 0)
                .orderByDesc(Comment::getCreateTime));
        List<CommentVO> voList = comments.stream().map(this::toVO).toList();
        return buildTree(voList);
    }

    @Override
    public void addComment(CommentDTO dto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(dto, comment);
        comment.setLikeCount(0);
        comment.setStatus(0);
        this.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        this.removeById(id);
    }

    private CommentVO toVO(Comment comment) {
        CommentVO vo = new CommentVO();
        BeanUtils.copyProperties(comment, vo);
        return vo;
    }

    private List<CommentVO> buildTree(List<CommentVO> list) {
        Map<Long, List<CommentVO>> grouped = list.stream()
                .filter(c -> c.getParentId() != null)
                .collect(Collectors.groupingBy(CommentVO::getParentId));
        List<CommentVO> roots = list.stream()
                .filter(c -> c.getParentId() == null || c.getParentId() == 0)
                .toList();
        for (CommentVO root : roots) {
            root.setReplies(grouped.getOrDefault(root.getId(), new ArrayList<>()));
        }
        return roots;
    }
}
