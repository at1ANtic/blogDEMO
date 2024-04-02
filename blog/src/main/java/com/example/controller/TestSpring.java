/*
package com.example.controller;

import com.example.pojo.Article;
import com.example.service.ArticleService;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.pdf.converter.PdfConverterExtension;
import com.vladsch.flexmark.profiles.pegdown.Extensions;
import com.vladsch.flexmark.profiles.pegdown.PegdownOptionsAdapter;
import com.vladsch.flexmark.util.options.DataHolder;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@MapperScan("com.example.mapper")
@Component
public class TestSpring {

    @Autowired
    private ArticleService articleService;

    @Test
    public void selectArticle() {
        List<Article> articles = articleService.selectArticle();
        for (Article article:articles) {
            System.out.println(article);
        }
    }

    @Test
    public void testNewArticle() {
        int result = articleService.newArticle("NewArticle");
    }
    @Test
    public void simpleTest() throws IOException {
        String html = markdown2Html();
        StringBuilder htmlStructBuilder = new StringBuilder();
        htmlStructBuilder.append("<html>");
        htmlStructBuilder.append("<head>");
        htmlStructBuilder.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("markdown.css");
        String styleContent = IOUtils.toString(stream, "UTF-8");
        htmlStructBuilder.append(String.format("<style type=\"text/css\"> %s </style>", styleContent));
        htmlStructBuilder.append("</head>");
        htmlStructBuilder.append(String.format("<body class='markdown-body'>%s</body>", html));
        htmlStructBuilder.append("<html>");
        PrintStream printStream = new PrintStream(new FileOutputStream(new File("test.html")), true);
        printStream.println(htmlStructBuilder.toString());
        printStream.close();
        DataHolder OPTIONS = PegdownOptionsAdapter.flexmarkOptions(true,
                Extensions.ALL
        );
        PdfConverterExtension.exportToPdf("test.pdf", htmlStructBuilder.toString(), "", OPTIONS);
    }

    */
/**
     * markdown文档转html内容
     *
     * @return
     * @throws IOException
     *//*

    private String markdown2Html() throws IOException {
        DataHolder OPTIONS = PegdownOptionsAdapter.flexmarkOptions(true,
                Extensions.ALL
        );

        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("test.md");
        String htmlContent = IOUtils.toString(stream, "UTF-8");

        Parser parser = Parser.builder(OPTIONS).build();
        HtmlRenderer renderer = HtmlRenderer.builder(OPTIONS).build();

        Node document = parser.parse(htmlContent);
        return renderer.render(document);
    }
}
*/
