package com.example.controller;

import com.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articleController")
public class ArticleController {

    @Autowired
    private ArticleService service;
    @RequestMapping()
    public String list(){
        return "articleList";
    }
    @PostMapping("/createArticle")
    public String createArticle(@RequestBody ArticleRequest articleRequest) {
        int result = service.newArticle(articleRequest.getTitle());
        if (result > 0) {
            return "文章创建成功！";
        } else {
            return "文章创建失败。";
        }
    }
    static class ArticleRequest {
        private  String id;
        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        }
}


