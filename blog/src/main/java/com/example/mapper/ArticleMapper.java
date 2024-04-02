package com.example.mapper;

import com.example.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    int insert(String title);

    int delete(String title);

    int update(Article id,String title);

    List<Article> selectArticle();

}
