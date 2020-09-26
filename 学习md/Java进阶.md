# Java 进阶

## Maven
Maven 为一个软件，有IDE集成的插件，他有一个中心仓库。
他是一个构建工具，自动下载中心仓库的jar文件，存在本地进行
管理，**编译**，**测试**，**运行**，和打包发布jar项目

* POM.xml

包含了项目信息，**依赖信息**，构建信息
构建信息
- groupId ： 组织
- artifactId ： 产品名称
- version ： 版本

* Maven项目基本目录结构
- src
    * main
        - java 存放java文件
        - resource 存放程序资源
    * test
        * java
        * resource
- pom.xml

