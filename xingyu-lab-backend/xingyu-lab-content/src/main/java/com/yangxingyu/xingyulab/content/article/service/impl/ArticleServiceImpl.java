package com.yangxingyu.xingyulab.content.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.common.exception.BusinessException;
import com.yangxingyu.xingyulab.common.exception.ErrorCode;
import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.content.article.dto.ArticleDTO;
import com.yangxingyu.xingyulab.content.article.entity.Article;
import com.yangxingyu.xingyulab.content.article.mapper.ArticleMapper;
import com.yangxingyu.xingyulab.content.article.service.ArticleService;
import com.yangxingyu.xingyulab.content.article.vo.ArticleListVO;
import com.yangxingyu.xingyulab.content.article.vo.ArticleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public PageResult<ArticleListVO> pageList(int pageNum, int pageSize, Long categoryId, String keyword) {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(categoryId != null, Article::getCategoryId, categoryId);
        wrapper.like(StringUtils.hasText(keyword), Article::getTitle, keyword);
        wrapper.eq(Article::getStatus, 1); // 只查已发布
        wrapper.orderByDesc(Article::getIsTop).orderByDesc(Article::getCreateTime);
        Page<Article> page = this.page(new Page<>(pageNum, pageSize), wrapper);
        return new PageResult<>(page.getTotal(), page.getRecords().stream().map(this::toListVO).toList());
    }

    @Override
    public ArticleVO getDetail(Long id) {
        Article article = this.getById(id);
        if (article == null) {
            throw new BusinessException(ErrorCode.ARTICLE_NOT_FOUND);
        }
        // 增加浏览量
        article.setViewCount(article.getViewCount() + 1);
        this.updateById(article);
        return toVO(article);
    }

    @Override
    public void addArticle(ArticleDTO dto) {
        Article article = new Article();
        BeanUtils.copyProperties(dto, article);
        article.setViewCount(0);
        article.setLikeCount(0);
        article.setCommentCount(0);
        if (article.getStatus() == null) {
            article.setStatus(0);
        }
        this.save(article);
    }

    @Override
    public void updateArticle(ArticleDTO dto) {
        Article article = new Article();
        BeanUtils.copyProperties(dto, article);
        this.updateById(article);
    }

    @Override
    public void deleteArticle(Long id) {
        this.removeById(id);
    }

    @Override
    public void publish(Long id) {
        Article article = this.getById(id);
        if (article == null) {
            throw new BusinessException(ErrorCode.ARTICLE_NOT_FOUND);
        }
        article.setStatus(1);
        this.updateById(article);
    }

    private ArticleListVO toListVO(Article article) {
        ArticleListVO vo = new ArticleListVO();
        BeanUtils.copyProperties(article, vo);
        return vo;
    }

    private ArticleVO toVO(Article article) {
        ArticleVO vo = new ArticleVO();
        BeanUtils.copyProperties(article, vo);
        return vo;
    }
}
