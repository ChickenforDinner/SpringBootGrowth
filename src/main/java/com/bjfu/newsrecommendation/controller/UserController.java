package com.bjfu.newsrecommendation.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/user")
public class UserController {
    @PostMapping("/information")
    public JSONObject information(){
        return null;
    }

    @RequestMapping("/news")
    public String login(){
        return "newsHome";
    }
}
