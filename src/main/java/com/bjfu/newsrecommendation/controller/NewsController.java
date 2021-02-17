package com.bjfu.newsrecommendation.controller;
import com.bjfu.newsrecommendation.DAO.News;
import com.bjfu.newsrecommendation.service.impl.NewsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/")
public class NewsController {
    @Resource
    NewsServiceImpl newsService;

    @RequestMapping(value = "home")
    public String home() {

        return "newsHome";
    }

    @RequestMapping(value = "news")
    public String detail() {

        return "newsDetail";
    }

    @ResponseBody
    @GetMapping(value = "allNews")
    public List<News> findNews(){
//        List<News> news = newsService.findNews();
        return newsService.findNews();
    }
}
