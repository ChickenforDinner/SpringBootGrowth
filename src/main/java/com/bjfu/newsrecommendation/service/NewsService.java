package com.bjfu.newsrecommendation.service;

import com.bjfu.newsrecommendation.DAO.News;

import java.util.List;

public interface NewsService {
    List<News> findNews();
}
