package com.bjfu.newsrecommendation.mapper;

import com.bjfu.newsrecommendation.DAO.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {
    List<News> allNews();
}
