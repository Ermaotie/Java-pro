### Java 学习笔记

* static 静态方法 称之为函数
与实例方法区分
* 自己编写的库
    * 编写用例 计算分为可控的部分
    * 实现API和一个能对方法进行独立测试的main()函数
    * 以达到模块化编程的目的

* 格式化输出 printf("%转换代码")
转换代码：
d: decimal f:float s: string
精度及对齐：
%n输出代码 : 输出至少n位，不够在左边补空格。 当n为负数时，当n大于位数时，在右边补齐空格 

* 编译
    * compile 只编译选定的目标，不管有没有编译过
    * build 整个工程全部重新构建
    * Make 只编译变化过的文件

    * idea中编译自带工程的环境路径
    * java可以使用类名来表示文件路径，javac不可以

* **《算法》binarySearch 配置不成功**


## 1.2 数据抽象
### 抽象数据类型(ADT)
着重操作，而不是数据类型
    * 适用于各种用途的API形式，准确描述问题。
    * 用API实现描述算法和数据结构。

* 实例方法
类中对其中对象的操作方法
* java中每个类都是Object的子类
    * 通用实例方法
    * ToString()
    * getClass()
    * equals(that)
    * hashCode()

* 内存管理
    * 孤儿对象
    示例：
    ```
    Date a = new Date(2001,6,26);
    Date b = new Date(2020,6,26);
    a = b;
    则此时a,b 为Date(2020,6,26)的同一引用，孤儿对象为Date(2001,6,26)，系统将自动释放
    ```

* 不可变性
    * final 只能用来保证原始数据类型的实例变量的不可变性，无法用于引用类型的变量。但对象本身的值依然是可以改变的
    * java中可变与不可变数据类型

| 可变数据类型 | 不可变数据类型 |
| :----: | :----: |
| Counter | Date |
| java数组 | String |


* 契约式设计
    * 异常(Exception)
    * 断言(Assertion)

    * ### 异常抛出
    ``` 
    // 创建自己的异常，最简单的一种
    throw new RuntimeException("Your Error message");
    ```
    
java 继承
* 类继承
### 继承特点
子类拥有父类非 private 的属性、方法。（即相当于C++中的public继承）

子类可以拥有自己的属性和方法，即子类可以对父类进行扩展。

子类可以用自己的方式实现父类的方法。

Java 的继承是单继承，但是可以多重继承，单继承就是一个子类只能继承一个父类，多重继承就是，例如 A 类继承 B 类，B 类继承 C 类，所以按照关系就是 C 类是 B 类的父类，B 类是 A 类的父类，这是 Java 继承区别于 C++ 继承的一个特性。

提高了类之间的耦合性（继承的缺点，耦合度高就会造成代码之间的联系越紧密，代码独立性越差）。

### 继承关键字
    * extends 单一继承
    ```
    public class A{···}
    public class B extend A {···}
    ```
    也可单继承接口
    
    * implements 接口多继承
* 接口继承 interface
支持多继承

this 指向 本类
super 最近的父级

### 接口
自带abstract
#### 描述
抽象方法的集合，一个类通过继承接口的方式，从而来继承接口的抽象方法。
接口不是类，类描述对象的属性和方法。接口则包含类要实现的方法。
除非实现接口的类是抽象类，否则该类要定义接口中的所有方法。

#### 特性
接口是隐式抽象的，当声明一个接口的时候，不必使用abstract关键字。
接口中每一个方法也是隐式抽象的，声明时同样不需要abstract关键字。
接口中的方法都是公有的。

#### 与抽象类的最大差别
接口不能包含成员变量，除了 static 和 final 变量。
抽象类含抽象方法即为抽象类


### 封装
```
public class Person{
    private String name;
    private int age;
​
    public int getAge(){
      return age;
    }
​
    public String getName(){
      return name;
    }
​
    public void setAge(int age){
      this.age = age;
    }
​
    public void setName(String name){
      this.name = name;
    }
}
```
### 增强的for循环
```
public class Test {
   public static void main(String args[]){
      int [] numbers = {10, 20, 30, 40, 50};
 
      for(int x : numbers ){
         System.out.print( x );
         System.out.print(",");
      }
      System.out.print("\n");
      String [] names ={"James", "Larry", "Tom", "Lacy"};
      for( String name : names ) {
         System.out.print( name );
         System.out.print(",");
      }
   }
}
```

* instanceof
判断左边的实例是否属于右边的类



