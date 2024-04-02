# JavaSSM框架后端开发博客DEMO记录

使用Spring，SpringMVC,MyBatis来做service，controller，和dao层。shiro来实现登陆的身份验证。

并不能说是一个完整的项目，只能说是一个demo吧，实现了这些框架中比较简单的功能，前端也是jsp，并没有使用到前端框架，主要就是熟悉后端框架。

## 项目结构

![image-20240331221753428](https://f1gure-bed.obs.cn-southwest-2.myhuaweicloud.com/image-20240331221753428.png)

先来说一下自己对三个后端的关系的理解吧。

SpringMVC用在controller层，通过注解用来接受发送到后端的请求来调用service的方法，service层则是通过注解来自动装配bean来实现IoC，service层有ArticleService接口用来声明实现的方法，ArticleServiceImpl来具体实现方法，然后调用MyBatis框架通过注释实现ArticleMapper的bean自动装配来实现数据库的操作。

## Maven配置

![image-20240331222821319](https://f1gure-bed.obs.cn-southwest-2.myhuaweicloud.com/image-20240331222821319.png)

开发用的pom.xml,将tomcat写入Maven里面方便测试

```
<build>
    <plugins>
      <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.1</version>
        <configuration>
          <port>80</port>
          <path>/</path>
        </configuration>
      </plugin>
    </plugins>
  </build>
```

如果要打war包就改成

```
<build>
    <finalName>blogdemo</finalName>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
```

## Spring配置

配置文件放在resources下面的applicationContext.xml文件里面

- 配置注解扫描的包的目录(spring处理service层和dao层，不处理controller层)
- 配置dao所在包
- spring整合mybatis需要配置连接池和配置SqlSession工厂
- shiro配置，以及配置需要鉴权的页面

## SpringMVC配置

配置文件放在resources下面的springmvc.xml

- 扫描controller包
- 配置视图解析器
- 配置使得静态资源不被过滤
- 开启springMVC对注解的支持

## MyBatis配置

配置文件放在resources下面的mybatis-config.xml

- 配置连接数据库
- 扫描Mapper注解

在src/java/example/mapper写接口来规范实现的对数据库的操作。

然后在resources新建com/exampel/mapper目录，不能加点号，要一个一个创建。用来放功能的Mapper.xml配置文件，里面配置了调用名称以及sql语句

## Docker部署

[使用 Dockerfile + Docker Compose 部署 Web 项目 - 掘金 (juejin.cn)](https://juejin.cn/post/7238918259755745339)

## 总结

使用框架开发感觉对于java编程语言的要求比较低，但是框架添加各种bean也是需要规范开发的。感觉刚开始学的时候比较摸不清头绪，做了简单的demo后也算理清了框架开发的整合。也没去看框架的源码来理解原理，可能对于开发岗的要求是远远达不到了，但是对于安全学习应该是铺垫了基础知识的，其实那些开发的内容就是需要花时间去做，相信聪明的自己也能很好学会。接下来的时间就要放到Java安全的学习以及ctf比赛上面了，Java开发学习就先告一段落吧，以后碰到知识再补充吧。