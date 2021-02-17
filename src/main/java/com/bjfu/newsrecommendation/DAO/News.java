package com.bjfu.newsrecommendation.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    private String title;
    private String content;
    private String author;
    private Boolean isHot;
    private Date createTime;
    private Date updateTime;

}
