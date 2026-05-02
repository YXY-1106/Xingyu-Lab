package com.yangxingyu.xingyulab.content.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.content.article.dto.ArticleDTO;
import com.yangxingyu.xingyulab.content.article.entity.Article;
import com.yangxingyu.xingyulab.content.article.vo.ArticleListVO;
import com.yangxingyu.xingyulab.content.article.vo.ArticleVO;

public interface ArticleService extends IService<Article> {
    PageResult<ArticleListVO> pageList(int pageNum, int pageSize, Long categoryId, String keyword);
    ArticleVO getDetail(Long id);
    void addArticle(ArticleDTO dto);
    void updateArticle(ArticleDTO dto);
    void deleteArticle(Long id);
    void publish(Long id);
}
