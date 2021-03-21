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
* 国际化编程
    * Java是第一个设计成支持国际化编程的语言
    - java.util.ResourceBundle 用于加载一个语言_国家语言包
    - java.util.Local 定义一个 语言_国家

    * 语言文件
    - 一个Properties文件
    - 包含K-V对
    - 命名规则
        * 包名+语言（+国家地区）.properties
        * message.properties
        * message_zh.properties
        * message_zh_CN.properties
    - 必须是ASCII码文件，ASCII以外的必须用Unicode的表示
        - 可以采用native2ascii.exe(%JAVA_HOME%\bin 目录)进行转码
```
Local myLocale = Local.getDefault();
// 根据指定语言_国家环境加载资源文件
ResourceBundle bundle = ResourceBundle.getBundle("message",myLocale);
// 打印国际化语言的“hello”
System.out.println(bunlde.getString("hello"));
```

## 高级文件处理
* xml简介
    - 数据+含义 适用于传输数据
    - ...


## Java多线程与多进程

### 多进程＆多线程
#### 多进程
* 每个独立执行的任务称为进程
* OS将时间划分为多个时间片
* **每个时间片内将CPU分配给每一个任务，时间片结束，CPU自动回收，再分配给其他任务**整体上看，所有任务同步进行，在CPU上，任务按照**串行**依次运行（单核CPU），单核上多进程只能串行进行。

* 多进程优点
    * IO堵塞时，提高CPU利用率
* 缺点
    * 笨重，不好管理，不好切换
#### 多线程
* 一个程序可以包括多个子任务（可串/可并）
* 每个子任务可以称为一个线程
* 一个子任务堵塞，可以调度给另一个子任务，而不需要更换进程。

* 多线程 vs 多进程
- 线程共享数据
- 线程通讯更高效
- 线程更轻量级，易切换
- 多个线程更容易管理

### 多线程实现
有且只有两种方法
* java.lang.Thread
- 线程继承Thread类，实现run方法
* java.lang.Runnable接口
- 线程实现Runnable接口，实现run方法

```
// 继承Thread类
public class Thread1 extends Thread{
    public void run()
    {
        System.out.println("hello");
    }
}

// 实现Runnable接口
public class Thread2 implements Runnable{
    public void run()
    {
        System.out.println("hello");
    }
}
```
 * 启动
 - start()，会自动以新进程调用run()  （JNI Java Native Interface: Java调用C/C++程序的底层API接口）
 - 直接调用run(),将变成串行执行
 - 同一个线程，多次start()会报错
 - 多个线程启动，启动先后顺序随机
 - 线程无需管理
 - main()可能早于新线程执行，整个程序并不结束
 - 整个程序终止是所有线程都终止

 * Thread vs Runnable
 - Thread 占据了父类的名额，不如Runnable方便
 - Runnable需要Thread类支持
 - Runnable 更容易实现多线程中的资源共享，在同一个main内，不需要static变量
 * 结论: 建议实现Runnable接口来完成多线程

 ### 多线程之间的信息共享

 * 细粒度: 线程之间有交流通讯
 - 通过共享变量--> 信息共享
 - JDK原生库暂不支持发送消息(类似MPI并行库直接发送消息)(MPI是一个信息传递应用接口，包括协议和语义说明。MPI的目标是高性能，大规模，可移植 Message_Passing_Interface)
 

 