### restful-api
#### 自动生成Restful风格CRUD接口框架，节约时间关注业务

#### 技术选型
-------------
Spring MVC、Mybatis、Mybatis-Plus(Mybatis增强插件)、Mysql、Maven、swagger2

#### 基本功能
-------------
1. 自动生成restful风格CRUD接口，可覆盖，可扩展，可禁止
2. AOP实现日志记录,开发者可实现LogApi接口灵活处理日志
3. 全局异常处理,响应统一格式的异常消息
4. 响应统一格式的JSON数据,日期格式化处理,JSONP支持

#### 接口文档
-------------
![image](https://github.com/alexdoop/restful-api/blob/master/imgs/p.png)

#### 快速开始
-------------
1. git clone https://github.com/alexdoop/restful-api.git
2. cd ~/restful-api && mvn install
3. cd restful-api-web && mvn jetty:run
4. http://localhost:8080/swagger-ui.html

#### 接口生成
-------------
1. 创建表tb_user,字段id(int),userName(varchar),password(varchar),age(int)
2. 使用test下的MysqlGenerator.java生成model,mapper,xml,service,并拷贝到当前项目对应的目录下
3. 在controller包下创建UserController,继承CurdController,再无需编写任何代码即可拥有CRDU四个标准的Restful风格接口
4. 重启项目,over,开发接口就是这么简单

#### 开发进度
-------------
正在努力开发中...
