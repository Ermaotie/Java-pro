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

## 单元测试与JUnit
- 单元vs 集成测试
    * 单元测试
    最小可测试单元 比如函数方法
    单元测试是已知代码结构进行的测试，属白盒测试
    * 集成测试
    多个单元相互作用，形成整体，对整体协调性进行测试。

- 白盒vs 黑盒测试
    * 白盒
    对一切的逻辑路径都进行测试
    * 黑盒 
    只测试接口
- 自动vs  手动测试
    * 程序批量
    * 手动

- 回归测试
    修改旧代码后，重新进行测试，**确认没有引入新的错误**
- 压力测试

### 测试策略

* 基于main函数策略
- 优点： 简单
- 缺点: 
    * 无法判断被测对象的行为是否符合预期
    * 繁琐
* JUnit
- 可通过maven引入依赖
- 以maven项目为例
```
import static org.junit.Assert.*; //导入Assert类下所有静态方法，可以直接使用方法名调用

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest{
    @Test //注解 标识后Junit测试
    public void test(){
        assertEquals(false,new Triangle().judgeEdge(1,2,3));
        // Assert.assertEquals(false,new Triangle().judgeEdge(1,2,3));
    }
}
```
- Maven pom.xml右键可以一键测试所有带@Test的单元

## 高级文本处理
* Java字符编码
- GB2312  7000多字
- GBK  20000多
- GB18030  70000多
- Big 5 繁体中文
- GB18030 > GBK >GB2310

* Unicode
- 不断扩充，存储全世界的所有字符
    * 编码方案
    - UTF-8 兼容ASCII，不够就变长(1到4个字节)
    - UTF-16 变长2或4个字节
    - UTF-32 统统4个字节存放
    