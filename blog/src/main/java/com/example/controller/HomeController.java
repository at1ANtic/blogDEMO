/*
package com.example.controller;

import com.example.pojo.Article;
import com.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ArticleService service;

    @RequestMapping("Article")
    public String homePage(Model model) {
        // 加载文章列表
        List<Article> articles = service.selectArticle();
        model.addAttribute("articles", articles);
        return "home"; // 返回 home.jsp 页面
    }

}
*/
