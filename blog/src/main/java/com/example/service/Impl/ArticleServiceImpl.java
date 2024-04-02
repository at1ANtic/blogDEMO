package com.example.service.Impl;

import com.example.mapper.ArticleMapper;
import com.example.pojo.Article;
import com.example.service.ArticleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> selectArticle() {
        System.out.println("ArticleServiceImpl的selectArticle方法执行了");
        return articleMapper.selectArticle();
    }

    @Override
    public int newArticle(String title) {
        // 插入文章标题到数据库
        int result = articleMapper.insert(title);

        // 在article目录下创建新的.md文件
        try {
            File directory = new File("article");
            if (!directory.exists()) {
                directory.mkdir();
            }
            File file = new File(directory, title + ".md");
            if (!file.exists()) {
                if (file.createNewFile()) {
                    FileWriter writer = new FileWriter(file);
                    writer.write("# " + title + "\n\nWrite your content here.");
                    writer.close();
                } else {
                    result = -1;
                }
            } else {
                result = -1;
            }
        } catch (IOException e) {
            e.printStackTrace();
            result = -1;
        }

        return result;
    }
    @Override
    public int deleteArticle(String title) {
        try {
            // Define article storage paths
            String articleFolderPath = "article/";
            String articleHtmlFolderPath = "articlehtml/";

            // Construct file paths
            String articleFilePath = articleFolderPath + title + ".md";
            String htmlFilePath = articleHtmlFolderPath + title + ".html";

            // Delete article file
            File articleFile = new File(articleFilePath);
            if (articleFile.exists()) {
                articleFile.delete();
            }

            // Delete HTML file
            File htmlFile = new File(htmlFilePath);
            if (htmlFile.exists()) {
                htmlFile.delete();
            }

            // Delete entry from the database
            articleMapper.delete(title);

            return 0; // Success
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Error
        }
    }


    @Override
    public int updateArticle(Article id, String newTitle) {
        try {
            // Get original article information
            String oldTitle = id.getTitle();

            // Define article storage paths
            String articleFolderPath = "article/";
            String articleHtmlFolderPath = "src/main/webapp/WEB-INF/articlehtml/";

            // Construct file paths
            String oldArticleFilePath = articleFolderPath + oldTitle + ".md";
            String oldHtmlFilePath = articleHtmlFolderPath + oldTitle + ".html";
            String newArticleFilePath = articleFolderPath + newTitle + ".md";
            String newHtmlFilePath = articleHtmlFolderPath + newTitle + ".html";

            // Rename article file
            File oldArticleFile = new File(oldArticleFilePath);
            File newArticleFile = new File(newArticleFilePath);
            oldArticleFile.renameTo(newArticleFile);

            // Rename HTML file
            File oldHtmlFile = new File(oldHtmlFilePath);
            File newHtmlFile = new File(newHtmlFilePath);
            oldHtmlFile.renameTo(newHtmlFile);

            // Update database with new title
            articleMapper.update(id, newTitle);

            return 0; // Success
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Error
        }
    }


    @Override
    public int writeArticle(String title, String markdownContent) {
        // 定义文章存储路径
        String articleFolderPath = "article/";
        // 构建文章文件名
        String articleFileName = title + ".md";
        // 构建文章全路径
        String articleFilePath = articleFolderPath + articleFileName;

        try {
            // 创建文章文件对象
            File articleFile = new File(articleFilePath);
            // 写入markdown内容到文章文件
            FileWriter writer = new FileWriter(articleFile);
            writer.write(markdownContent);
            writer.close();

            // 调用MarkdownUtils将md文件转换为html并保存在指定目录下
            String htmlContent = com.example.utils.MarkdownUtils.markdownToHtmlExtensions(markdownContent);
            String htmlFilePath = "D:\\语言学习\\java学习\\blog\\blog\\src\\main\\webapp\\WEB-INF\\articlehtml\\" + title + ".html";
            FileWriter htmlWriter = new FileWriter(htmlFilePath);
            htmlWriter.write(htmlContent);
            htmlWriter.close();

            return 0; // 成功写入文章
        } catch (IOException e) {
            e.printStackTrace();
            return -1; // 写入过程出现异常
        }
    }

    @Override
    public String findArticle(Article id) {
        return id.getTitle();
    }
    @Test
    public void Test()
        {
            // 创建 ArticleWriter 对象
            ArticleServiceImpl articleWriter = new ArticleServiceImpl();

            // 调用 writeArticle 方法测试
            int result = articleWriter.writeArticle("test_article","aaa");

            // 检查写入结果
            if (result == 0) {
                System.out.println("文章成功写入！");
            } else {
                System.out.println("文章写入失败！");
            }
        }
}
