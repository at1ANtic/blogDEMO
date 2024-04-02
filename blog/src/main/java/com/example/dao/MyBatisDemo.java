package com.example.dao;

import com.example.mapper.ArticleMapper;
import com.example.pojo.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;


/**
 * MyBatis快速入门
 */
public class MyBatisDemo {
    public static void main(String[] args) throws Exception {

        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行SQL
        /*List<Article> articles = sqlSession.selectList("com.example.mapper.ArticleMapper.selectArticle");*/
        ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
        List<Article> articles = articleMapper.selectArticle();
        System.out.println("Articles = " + articles);
        //4.释放 SqlSession
        sqlSession.close();

    }
}
