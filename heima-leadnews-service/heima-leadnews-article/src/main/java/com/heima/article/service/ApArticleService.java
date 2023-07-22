package com.heima.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.common.dtos.ResponseResult;

import java.util.List;

/**
 * @author nightmare
 * @date 2023/7/20 18:31
 */
public interface ApArticleService extends IService<ApArticle> {
    /**
     * 加载文章列表
     * @param dto
     * @param type  1：表示加载更多  2 加载最新
     * @return
     */
    public ResponseResult load(ArticleHomeDto dto, Short type);
}
