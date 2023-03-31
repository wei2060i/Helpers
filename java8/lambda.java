package com.generator.controller;

import org.apache.logging.log4j.util.Supplier;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class lambda {
    public static void main(String[] args) {
        test3D();
    }

    /**
     * 数组引用
     */
    public static void test6() {
        Function<Integer, String[]> f = x -> new String[x];
        String[] s = f.apply(4);
        Function<Integer, String[]> fun = String[]::new;
        String[] ss = fun.apply(5);
    }

    /**
     * 构造器引用
     * 需要调用的构造器参数列表需要与函数式接口中抽象方法的参数列表一致
     */
    public static void test5() {
        Supplier f = String::new;
        f.get();//获取String的对象
        Function<String ,StringBuffer> fun = StringBuffer::new;
        StringBuffer s = fun.apply("22");
    }

    /**
     * 方法引用
     * 对象::实例方法名
     * 类::静态方法名
     * 类::实例方法名
     * Lambda体中调用方法的参数列表和返回值类型，要和函数式接口中抽象方法的参数列表和返回值类型一样
     */
    public static void test4() {
        //对象::实例方法名
        Consumer c1 = i -> System.out.println(i);
        Consumer c = System.out::println;
        //类::静态方法名
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> co = Integer::compare;
        /**
         *类::实例方法名
         *两个参数,第一个参数实例方法的调用者，第二个参数是实例方法的参数时可以用之。
         */
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        BiPredicate<String, String> b = String::equals;
    }

    /**
     * java8 内置四大核心函数式接口-函数型接口
     * Function	            apply	(T) -> R
     * BiFunction	        apply	(T, U) -> R
     * DoubleFunction	    apply	(double) -> R
     * DoubleToIntFunction	applyAsInt	(double) -> int
     * DoubleToLongFunction	applyAsLong	(double) -> long
     * IntFunction	        apply	(int) -> R
     * IntToDoubleFunction	applyAsDouble	(int) -> double
     * IntToLongFunction	applyAsLong	 (int) -> long
     * LongFunction	        apply	 (long) -> R
     * LongToDoubleFunction	applyAsDouble	(long) -> double
     * LongToIntFunction	applyAsInt	(long) -> int
     * ToDoubleFunction	    applyAsDouble	(T) -> double
     * ToDoubleBiFunction	applyAsDouble	(T, U) -> double
     * ToIntFunction	    applyAsInt	(T) -> int
     * ToIntBiFunction	    applyAsInt	(T, U) -> int
     * ToLongFunction	    applyAsLong	(T) -> long
     * ToLongBiFunction	    applyAsLong	(T, U) -> long
     */
    public static void test3D() {
        Function<String, Object> f = str -> str.toUpperCase();
        System.out.println(f.apply("s dddf"));
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.stream().mapToInt(i -> i+1);
        BinaryOperator<Integer> add = BinaryOperator.maxBy(Comparator.naturalOrder());
        System.out.println(add.apply(2,3));
    }

    /**
     * java8 内置四大核心函数式接口-断言型接口
     * Predicate	   test	 (T) -> boolean
     * BiPredicate	   test	 (T, U) -> boolean
     * DoublePredicate test	 (double) -> bool
     * IntPredicate	   test	 (int) -> boolean
     * LongPredicate   test	 (long) -> boolean
     */
    public static void test3C() {
        Predicate<Integer> p = i -> i > 0;
        System.out.println(p.test(-2));
        IntPredicate intP = (int i) -> i % 2 == 0;
        System.out.println(intP.test(20));
        BiPredicate<Integer, BigInteger> biP = (Integer i, BigInteger j) -> {
            return j.intValue() == i;
        };
        System.out.println(biP.test(5, new BigInteger("5")));
        Predicate<Integer> p2 = i -> i % 2 == 0;
        //大于0 或者 是偶数
        System.out.println(p.or(p2).test(-2));
    }

    /**
     * java8 内置四大核心函数式接口-消费者接口
     * Consumer	         accept	(T) -> void
     * DoubleConsumer	 accept	(double) -> void
     * IntConsumer	     accept	(int) -> void
     * LongConsumer	     accept	(long) -> void
     * ObjDoubleConsumer accept	(T, double) -> void
     * ObjIntConsumer	 accept	(T, int) -> void
     * ObjLongConsumer	 accept	(T, long) -> void
     */
    public static void test3B() {
        Consumer<Integer> c = i -> System.out.println(i);
        c.accept(4);
        Consumer<String> c2 = i -> System.out.println(i.toUpperCase());
        Consumer<String> c3 = i -> System.out.println(i.toLowerCase());
        //转大写、再转小写
        c2.andThen(c3).accept("dnF");
        DoubleConsumer dou = i -> System.out.println(i /= 2);
        dou.accept(9);

        ObjIntConsumer<List<Integer>> fun = (list, num) -> {
            list.stream().forEach(a -> System.out.println(a * num));
        };
        List<Integer> list = Arrays.asList(1, 2, 3);
        fun.accept(list, 2);
    }

    /**
     * java8 内置四大核心函数式接口-供给型接口
     * Supplier<T>      get()            () -> T
     * BooleanSupplier	getAsBoolean()   () -> boolean
     * DoubleSupplier	getAsDouble()	 () -> double
     * IntSupplier	    getAsInt()	     () -> int
     * LongSupplier  	getAsLong()	     () -> long
     */
    public static void test3A() {
        Supplier<Double> s = () -> Math.random();
        System.out.println(s.get());
        BooleanSupplier bool = () -> LocalDate.now().isLeapYear();
        System.out.println("是闰年:" + bool.getAsBoolean());
        DoubleSupplier randomDs = () -> new Random().nextDouble();
        System.out.println(randomDs.getAsDouble());
        System.out.println("生成3个int数值");
        IntStream.generate(() -> new Random().nextInt(10)).limit(3)
                .forEach(System.out::println);
        LongSupplier multiplyLs = () -> {
            long num1 = 30L;
            long num2 = 50L;
            return num1 * num2;
        };
        System.out.println(multiplyLs.getAsLong());
    }

    public static void test2() {
        List<String> list = new ArrayList<>();
        list.add("beijing");
        list.add("shanghai");
        list.add("tianjin");
        Collections.sort(list, (x, y) -> x.compareTo(y));
        list.forEach(i -> System.out.println(i));
    }

    public static void test1() {
        //没有参数  () -> System.out.println("......");
        //两个参数  (x,y) ->System.out.println(y+"......"+x);
        //左右遇一 括号可省;右面如果只有一条return语句时,return可以省略不写。
        MyLambdaTest m = i -> System.out.println(i);
        m.test("hahahahaha");
    }
}

@FunctionalInterface
interface MyLambdaTest<T> {
    void test(T t);
}
