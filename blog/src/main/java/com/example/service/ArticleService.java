package com.example.service;

import com.example.pojo.Article;

import java.util.List;

public interface ArticleService {
   List<Article> selectArticle();
   int newArticle(String title);
   int deleteArticle(String title);
   int updateArticle(Article id,String title);
   int writeArticle(String title,String markdownContent);
   String findArticle(Article id);
}
