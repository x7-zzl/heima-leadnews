package com.heima.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author nightmare
 * @date 2023/7/20 18:09
 */
@Mapper
public interface ApArticleMapper extends BaseMapper<ApArticle> {

    /**
     * 加载文章列表
     * @param dto
     * @param type  1：表示加载更多  2 加载最新
     * @return
     */
    public List<ApArticle> loadArticleList(ArticleHomeDto dto,Short type);
}
