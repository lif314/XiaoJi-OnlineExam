# 小济在线考试系统--后端

## 技术栈
- SpringBoot 2.6.7
- MyBatisPLUS: 
- MySQL: 5.7
- Swagger:  3.0
- knife4j
- Java: 1.8


## 运行
- 开发环境：IDEA 2021 + Maven 3.8
- 执行`./sql`目录下的脚本，创建数据库`xiaoji_exam`
- 在`application.properties`配置文件中更改连接数据库的地址
```properties
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.url=jdbc:mysql://localhost:3306/xiaoji_exam?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
```
- 启动运行
