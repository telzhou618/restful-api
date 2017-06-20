# restful-api
自动生成Restful风格CRUD接口框架，节约时间关注业务
技术架构
-------------
Spring MVC、Mybatis、Mybatis-Plus(Mybatis增强插件)、Mysql、Maven、swagger2

接口文档
-------------
![image](https://github.com/alexdoop/restful-api/blob/master/imgs/p.png)

快速开始
-------------
1. git clone https://github.com/alexdoop/restful-api.git
2. cd ~/restful-web-api
3. mvn install
4. mvn jetty:run
5. http://localhost:8080/swagger-ui.html

接口生成
-------------
1. 创建表tb_user,字段id(int),userName(varchar),password(varchar),age(int)
2. 使用test下的MysqlGenerator.java生成model,mapper,xml,service,并拷贝到当前项目对应的目录下
3. 在controller包下创建UserController,继承CurdController,再无需编写任何代码即可拥有CRDU四个标准的Restful风格接口
4. 重启项目,over,开发接口就是这么简单

开发进度
-------------
正在努力开发中...
