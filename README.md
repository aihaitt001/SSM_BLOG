# SSM_Demo  
项目已经部署到阿里云，网址：www.lifeforfun.cn

1. SSM框架的搭建，并实现CRUD --11.2
2. 增加登陆功能。--11.7
3. 配置拦截器，完成用户的增删改查。 --11.8 ~11.17
4. 完成文章的service和持久层。  --11.20 ~ 11.24
5. 尝试使用Thymeleaf模板进行html页面的解析。 --11.27
6. 尝试使用REST风格。更改拦截器配置。--11.28
  7. 1. 新增查看文章列表    --11.29
7. 1. 尝试mockmvc+JUnit 进行控制器的测试。
    2. 增加点击文章转到文章详情   --11.30

8. 1. 加入新增文章的模态框 --12.1
  2. 在artcle页面新增删除 
  3. 引入Bootstrap框架，美化网站。--12.3~12.19
  4. 加入修改的模态框    --12.26

9. 1. 新增管理员界面，提供用户管理功能 --12.27
     2. 采用QQ邮箱的服务器，增加发送邮件功能 --12.28
  10. 登陆后，导航条自动改变。
  11. 增加用户注销功能。            -- 12.29

12. 1. 改为利用druid连接数据库，启用并配置config_filter给数据库密码加密。 
    2. 放弃自定义的interceptor,采用shiro进行登陆检测和权限控制（未完成）。 --2018.1.2

13. 1. 利用shiro完成了初步的权限管理，替代了自定义的拦截器。 --2018.1.8~2018.1.17
   2. 项目已经部署到阿里云，网址：www.lifeforfun.cn   --2018.1.18
    3. 用户密码实现了MD5加密存储  --2018.1.23
      （1）利用java.io.SimpleHash完成对密码的MD5加密和加随机盐（见MD5Util）。
       （2）配置org.apache.shiro.authc.credential.HashedCredentialsMatcher，并添加到Realm中，完成shiro对解密的配置。（见applicationContext.xml）
        (3) 在Realm中验证用户时，加盐，完成密码的解码（见MyRealm）。

14. 1. 加入redis作为验证用户登录的服务器，和shiro.web.filter.AccessControlFilter一起实现单人登陆（见KickoutControlFilter）。--2018.1.24-2018.2.2
       （1）redis采用JedisPool来管理连接。
       （2）在redis.properties中配置redis的连接。
15. 1. 利用InitializingBean在程序启动后自动初始化。2018.2.3
16. ​    2018.3.14
   1. 完善注册功能。
   2. 修复ajax请求返回text为乱码的BUG（response.ContentType不一致问题）。


  