package com.heima.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.article.mapper.ApArticleMapper;
import com.heima.article.service.ApArticleService;
import com.heima.common.constants.ArticleConstants;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.common.dtos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author nightmare
 * @date 2023/7/20 18:31
 */
@Service
@Slf4j
@Transactional
public class ApArticleServiceImpl extends ServiceImpl<ApArticleMapper, ApArticle> implements ApArticleService {
    @Autowired
    private ApArticleMapper apArticleMapper;

    private final static short MAX_PAGE_SIZE=50;
    /**
     * 加载文章列表
     * @param dto
     * @param type  1：表示加载更多  2 加载最新
     * @return
     */
    @Override
    public ResponseResult load(ArticleHomeDto dto, Short type) {

        //校验参数-size
        //分页参数的校验
        Integer size = dto.getSize();
        if(size==null||size==0){ //默认是10
            size=10;
        }
        //分页的最大值不超过50
        size=Math.min(size,MAX_PAGE_SIZE);

        //校验参数-type
        if(!type.equals(ArticleConstants.LOADTYPE_LOAD_MORE)&&!type.equals(ArticleConstants.LOADTYPE_LOAD_NEW)){
            type=ArticleConstants.LOADTYPE_LOAD_MORE;
        }
        //频道参数校验
        if(StringUtils.isBlank(dto.getTag())){  //默认加载所有的
            dto.setTag(ArticleConstants.DEFAULT_TAG);
        }
        //时间参数校验
        if(dto.getMaxBehotTime()==null){
            dto.setMaxBehotTime(new Date());
        }
        if(dto.getMinBehotTime()==null){
            dto.setMinBehotTime(new Date());
        }

        List<ApArticle> articleList = apArticleMapper.loadArticleList(dto,type);

        return ResponseResult.okResult(articleList);
    }
}
