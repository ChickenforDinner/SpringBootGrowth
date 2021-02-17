package com.bjfu.newsrecommendation.service.impl;

import com.bjfu.newsrecommendation.DAO.News;
import com.bjfu.newsrecommendation.mapper.NewsMapper;
import com.bjfu.newsrecommendation.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    NewsMapper newsMapper;

    @Override
    public List<News> findNews() {
        try{
            newsMapper.allNews();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return newsMapper.allNews();
    }
}
