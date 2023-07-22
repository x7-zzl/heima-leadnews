package com.heima.model.article.dtos;

/**
 * @author nightmare
 * @date 2023/7/20 18:04
 */
import lombok.Data;

import java.util.Date;

@Data
public class ArticleHomeDto {

    // 最大时间
    Date maxBehotTime;
    // 最小时间
    Date minBehotTime;
    // 分页size
    Integer size;
    // 频道ID
    String tag;
}