package com.java8;

import org.apache.logging.log4j.util.Supplier;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class lambda {
    public static void main(String[] args) {
        test4();
    }
    /**
     * 数组引用
     */
    public static void test6(){
        Function<Integer,String[]> f = x->new String[x];
        String[] s = f.apply(4);
        Function<Integer,String[]> fun =String[]::new;
        String[] ss = fun.apply(5);
    }
    /**
     * 构造器引用
     * 需要调用的构造器参数列表需要与函数式接口中抽象方法的参数列表一致
     */
    public static void test5(){
        Supplier f = String::new;
        f.get();//获取String的对象
        Function<String,String> fun =String::new;
        String s = fun.apply("22");
    }
    /**
     *方法引用
     * 对象::实例方法名
     * 类::静态方法名
     * 类::实例方法名
     *Lambda体中调用方法的参数列表和返回值类型，要和函数式接口中抽象方法的参数列表和返回值类型一样
     */
    public static void test4(){
        //对象::实例方法名
        Consumer c1 = i-> System.out.println(i);
        Consumer c = System.out::println;
        //类::静态方法名
        Comparator<Integer> com = (x,y)-> Integer.compare(x,y);
        Comparator<Integer> co = Integer::compare;
        /**类::实例方法名
         *两个参数，第一个参数实例方法的调用者，第二个参数是实例方法的参数时可以用之。
         */
        BiPredicate<String,String> bp = (x,y)-> x.equals(y);
        BiPredicate<String,String> b = String::equals;
    }
    /**java8 内置四大核心函数式接口
     * Consumer<T>消费者接口  void accept(T t)
     * Supplier<T>供给型接口 T get()
     * Function<T,R> 函数型接口 R apply(T t)
     * Predicate<T> 断言型接口 Boolean test(T t)
     * 其他的百度去学
     */
    public static void test3(){
        Consumer c = i-> System.out.println(i);
        c.accept(4);

        Supplier s =()-> Math.random();
        System.out.println(s.get());;

        Function<String,Object> f = str -> str.toUpperCase();
        System.out.println(f.apply("s dddf"));;

        Predicate<Integer> p = i-> i > 0;
        System.out.println(p.test(-2));
    }
    public static void test2(){
        List<String> list = new ArrayList<>();
        list.add("beijing");
        list.add("shanghai");
        list.add("tianjin");
        Collections.sort(list,(x,y) -> x.compareTo(y));
        list.forEach(i-> System.out.println(i));
    }
    public static void test1(){
        //没有参数  () -> System.out.println("......");
        //两个参数  (x,y) -> System.out.println(y+"......"+x);
        //左右遇一  可括号省 ;右面一条语句时，如果有return可以省略不写
        MyLambdaTest m = i -> System.out.println(i);
        m.test("hahahahaha");
    }
}

@FunctionalInterface
interface MyLambdaTest<T>{
    void test(T t);
}
