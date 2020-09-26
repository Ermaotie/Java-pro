$ 项目复现
## [vueblog](https://segmentfault.com/a/1190000022777009)
### 后端
1. springBoot && mybatisplus

在IDEA中选择springBoot，若无，则在插件中搜索Spring Assistant。然后填好包名等，一路next。

在pom.xml中修改稳定版本,改为2.2.6

```
    <parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.3.4.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
```

整合mybatisplus，添加依赖
为什么要整合freemarker?
mybatisplus需要基于一个模板来生成代码，freemarker即是

写配置文件**Application.yml**

```
# DataSource Config
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/vueblog?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai
    username: root
    password: admin
mybatis-plus:
  mapper-locations: classpath*:/mapper/**Mapper.xml
```
上面除了配置数据库的信息，还配置了myabtis plus的mapper的xml文件的扫描路径，这一步不要忘记了。

### mybatis config
### CodeGenerator

#### mysql建表
#### mysql [安装](https://www.runoob.com/mysql/mysql-install.html)
* 在执行**mysqld install**一句时若提示权限不足，则使用管理员身份打开cmd


redis


### @component 与 @Autowired
