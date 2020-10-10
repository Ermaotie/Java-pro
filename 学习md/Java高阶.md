# JAVA 高阶

## 语法糖
1. for-each
2. enum

* enum
枚举变量，集合内只有有限的数量。
enum为自带的Enum的子类，其中可以放置实例化的对象
代码示例：
```
enum Fruit
{
    APPLE(10), ORANGE(8);
    private int price;
    Fruit(int price)
    {
        this.price=price;
    }
    
    //封装
    public int getPrice()
    {
        return this.price;
    }
}

Fruit xxx = Fruit.APPLE;
Systen.out.println(xxx.getPrice());
```

继承了Enum的函数
--ordinal() 返回索引值；
--compareTo() 比较俩个索引值的大小；
--toString() 
--valueOf() 将字符串初始化为枚举对象
--values  返回所有枚举值

3. 不定项参数
JDK5+
--类型后面加  **...**
--可变参数，本质上是一个数组

- 一个方法只能有一个不定项参数，且必须位于最后
- 重载优先级规则
    * 固定参数的方法，比可变优先级高
    * 调用语句，同时，与俩个带可变参数的方法匹配，报错

4. 自动装拆箱(auto-boxing || auto-unboxing)
JDK5.0+
- 基本类型：boolean/int/...
- 对象：    Boolean/Integer/...

- 基础类型没有空值，而对象有空值(null)

5. 多异常并列
-JDK 7.0+
```
try
{
    test();
}
catch(IOException ex)
{
    //异常处理
}
catch(SCLException)
{
    // 异常处理
}
```
多个异常之间不能有继承关系。

6. int 类型赋值
-可以通过二进制来赋值(前面加0b)
```
int a = 0b01001000;
```

* 数值字面量(literal)
    * 使用下划线 **_**
下划线可增强可读性

前缀：
-0b  二进制
-0   八进制
-0x  十六进制

后缀
-f float
-L long

* **接口与抽象类**
java最初的设计中，接口的默认方法都是**没有实现的，公开的**
java 8+ 推出接口的默认和静态方法(都带实现的)，为lambda表达式提供支持

    * 接口的默认方法
        - 以default关键字标注
        - 不能重写Object中的方法
        - 接口，实现类可以继承/重写 父接口中的默认方法
        - 父接口与父类同名同参默认方法，子类继承父类中的，目的为兼容java7及以前的版本。
        - 子类继承或实现了两个同名同参的默认方法，需在子类中重新定义该方法。
    * 接口的静态方法
        - static
        - 静态方法由于在JVM中不需要实例化，直接调用，因此不能含有非静态的参数或方法。即在静态方法中，无法调用默认方法。
        - 子类(子接口)没有继承父类的静态方法，只能通过所在接口名来调用。
    * 接口的私有方法
        - 只能在本接口内使用，子类无法继承，也无法调用
    * 接口 vs 抽像类
        - 接口的变量默认是 public static final (即无法修改)
* var类型
    * 局部变量，由编译器推断类型，且推断后不能更改，最好不要滥用
    * 不能成为类的成员

## 泛型
* 泛型入门
    * Arraylist，hashset等
    * 泛型类
    * 泛型接口
    * 泛型方法