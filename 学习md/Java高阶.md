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
* java interface
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
    * 泛型类
        * Arraylist，hashset等
    * 泛型接口
        * List, Iterator
    * 泛型方法
        * Array.sort,Coolections.binarySearch

```
// Iterator接口
Iterator<String> iter = list.iterator();
while(iter.hasNext()){
    System.out.println(iter.next());
}

Iterator<Double> iter = list.iterator();
while(iter.hasNext()){
    System.out.println(iter.next());
}
// 基础数据类型不能做泛型
```

### 自定义泛型
* 泛型类 
- 具有泛型变量的类
- 类名后用\<T\>代表引入类型
    * 多个字母表示多个引入类型，如\<T,U\>
    * 引入类型可以修饰成员变量/局部变量/参数/返回值
    * 没有专门的template关键字
```
public class Interval<T>{

    private T lower;
    private T upper;

    public Interval(T lower,T upper){
        this.lower = lower;
        this.upper = upper;
    }

    public T getlower(){
        return lower;
    }
}

// demo use
Interval<Integer> = new Iterval<>(1,2);

// demo function
public static <T> Iterval<T> getReverse(Interval<T> interval){
    // 第一个<T>表示引入类型
    return new Interval<T>(interval.getUpper(), interval.getLower());
}
```

* 泛型方法
- 见上
- 具有泛型变量的方法
- <T> 在修饰符后，返回类型前
- 若方法含有多个T泛型类参数，各个参数不同时，T默认为各参数的父类。

* 泛型接口
可以以泛型为泛型的变量

### 泛型约束
* 泛型限定
示例：
```
<T extends Comparable & Serializable, U extends Serializable>
```
* extends 表示限定继承后面的类或接口的class才合法，仅可extends，不能implements
* 以&连接，最多一个类且必须在第一位
* 泛型通配符
    * <T ? extends xxx>
    限定上限，生产者，只能读不能写
    * <T ? super xxx>
    限定下限，消费者，只写不读

### 泛型实现本质
* java是向后兼容的，jdk1.5引入泛型，而1.4前class文件在之后的JVM中依然可以运行。**因此，JVM中不存在泛型对象，而是采用了类型擦除技术，只有普通的类和方法。
* 擦除泛型变量，替换为原始类型(raw type) 
* 擦除后，为了保证类型安全性，需要自动进行类型转换
```
Fruit a = fruits.getFirst();
// 翻译为
Object a1 = fruits.getFirst();
Fruit a = (Fruit) a1;
```
### java类型的协变和逆变
协变 数组 泛型extend
逆变 泛型super
不变 普通泛型
双变
