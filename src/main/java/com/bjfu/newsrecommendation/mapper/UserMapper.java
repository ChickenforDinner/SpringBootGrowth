package com.bjfu.newsrecommendation.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    String findNews();
}
