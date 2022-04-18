package com.generator.controller;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.IntegerSyntax;
import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class stream {
    static List<Employee> l = Arrays.asList(
            new Employee("张三", 3),
            new Employee("李四", 32),
            new Employee("王五", 33),
            new Employee("赵六", 323),
            new Employee("李四", 32));

    static List<Employee> employees = Arrays.asList(
            new Employee("张三", 3, Status.BUSY),
            new Employee("李四", 32, Status.FREE),
            new Employee("王五", 33, Status.VOCATION),
            new Employee("赵六", 323, Status.BUSY),
            new Employee("李四", 32, Status.FREE));


    public static void main(String[] args) {
        toTree10();
    }


    public static void toTree10() {
        //模拟从数据库查询出来
        List<Menu> menus = Arrays.asList(
                new Menu(1, "根节点", 0),
                new Menu(2, "子节点1", 1),
                new Menu(3, "子节点1.1", 2),
                new Menu(4, "子节点1.2", 2),
                new Menu(5, "根节点1.3", 2),
                new Menu(6, "根节点2", 1),
                new Menu(7, "根节点2.1", 6),
                new Menu(8, "根节点2.2", 6),
                new Menu(9, "根节点2.2.1", 7),
                new Menu(10, "根节点2.2.2", 7),
                new Menu(11, "根节点3", 1),
                new Menu(12, "根节点3.1", 11)
        );
        //获取父节点
        List<Menu> collect = menus.stream().filter(m -> m.getParentId() == 0).map(
                (m) -> {
                    m.setChildList(getChildren(m, menus));
                    return m;
                }
        ).collect(Collectors.toList());
        System.out.println(JSON.toJSON(collect));
    }

    /**
     * 递归查询子节点
     *
     * @param root 根节点
     * @param all  所有节点
     * @return 根节点信息
     */
    private static List<Menu> getChildren(Menu root, List<Menu> all) {
        List<Menu> children = all.stream().filter(m -> Objects.equals(m.getParentId(), root.getId())).map(
                (m) -> {
                    m.setChildList(getChildren(m, all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }

    /**
     * 并行流
     * parallel()
     */
    public static void test9() {
        Instant start = Instant.now();
        LongStream.rangeClosed(0, 10000000L).parallel()
                .reduce(0, Long::sum);
        //结束
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
    }

    /**
     * collect  收集 将流转换为其他形式,接收Collectors接口的实现用于汇总
     */
    public static void test8() {
        List<Integer> c = l.stream().map(Employee::getAge).collect(Collectors.toList());
        c.forEach(System.out::println);
        Set<Integer> collect = l.stream().map(Employee::getAge).collect(Collectors.toSet());
        collect.forEach(System.out::println);
        HashSet<Integer> collect1 = l.stream().map(Employee::getAge).collect(Collectors.toCollection(HashSet::new));
        collect1.forEach(System.out::println);
        Long count = l.stream().collect(Collectors.counting());
        Double avg = l.stream().collect(Collectors.averagingInt(Employee::getAge));
        Integer sum = l.stream().collect(Collectors.summingInt(Employee::getAge));
        Optional<Integer> min = l.stream().map(Employee::getAge).collect(Collectors.minBy(Integer::compare));
        System.out.println(min.get());
        //分组
        Map<Status, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
        //多级 分组  先Status再age
        Map<Status, Map<String, List<Employee>>> mapDuo = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
            if (e.getAge() <= 30) {
                return "青年";
            } else if (e.getAge() <= 50)
                return "中年";
            else return "老年";
        })));
        //按照条件 分区  真区   假区
        Map<Boolean, List<Employee>> bool = employees.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 50));
        //组函数
        IntSummaryStatistics zuFx = employees.stream().collect(Collectors.summarizingInt(Employee::getAge));
        System.out.println(zuFx.getMax() + "  " + zuFx.getCount());
        //组合在一起
        String Collating = employees.stream().map(Employee::getName).collect(Collectors.joining(",", "前缀", "后缀"));
        System.out.println(Collating);

    }

    /**
     * 规约 reduce(T identity,BinaryOperator)/ reduce(BinaryOperator)
     * 将流中元素反复结合起来
     */
    public static void test7() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        //结果可能为空 的 返回到Optional容器
        Optional<Integer> reduce1 = l.stream().map(Employee::getAge).reduce(Integer::sum);
        System.out.println(reduce1.get());
        //连接字符串
        String reduce2 = l.stream().map(Employee::getName).reduce("", String::concat);
    }

    /**
     * 查找与匹配
     * allMatch---检测是否匹配所有元素
     * anyMatch 检测是否至少匹配一个元素
     * noneMatch 检测是否没有匹配所有元素
     * findFirst 返回第一个元素
     * findAny 返回当前流中的任意元素
     * count 返回元素个数
     * MAX   MIN   最大最小
     */
    public static void test6() {
        boolean b = employees.stream().allMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b);
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first.get());
        // parallelStream并行流，多个线程并行查找哦
        Optional<Employee> any = employees.parallelStream().filter(i -> i.getStatus().equals(Status.BUSY)).findAny();
        System.out.println(any.get());
        employees.stream().count();
        Optional<Employee> max = employees.stream().max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println(max);
        Optional<Integer> min = employees.stream().map(Employee::getAge).min(Integer::compareTo);
    }

    /**
     * 排序 sorted() 自然排序(Comparable)
     * 定制排序 sorted(Comparator 接口)
     */
    public static void test5() {
        List<String> ls = Arrays.asList("aaa", "bbb", "cccc", "hhh");
        ls.stream().sorted().forEach(System.out::println);
        System.out.printf("***************************");
        l.stream().sorted((e1, e2) -> {
            if (e1.getAge().equals(e2.getAge()))
                return e1.getName().compareTo(e2.getName());
            else return e1.getAge().compareTo(e2.getAge());
        });

    }

    /**
     * 映射
     * map->接收lambda,将元素转换成其他形式或提取信息。接收一个函数作为参数,该函数会被应用到
     * 每个元素上，并将其映射成一个新元素。
     * flatMap接收一个函数作为参数,将流中的每个值都换成另一个流，然后把所有的流连接成一个流。
     */
    public static void test4() {
        List<String> ls = Arrays.asList("aaa", "bbb", "cccc", "hhh");
        Stream<String> stringStream = ls.stream().map(s -> s.toUpperCase());
        stringStream.forEach(System.out::println);

        l.stream().map(s -> s.getName()).forEach(System.out::println);
        System.out.printf("------------------------------------------");
        //传参数是流，返回流嵌套流，把所有的流连接成一个流。
        Stream<Stream<Character>> rr = ls.stream().map(stream::filterCharacter);
        rr.forEach(r -> {
            r.forEach(System.out::println);
        });
        //将流中的每个值都换成另一个流,注意传入的是stream
        Stream<Character> characterStream = ls.stream().flatMap(stream::filterCharacter);
        characterStream.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    /**
     * 帅选与切片
     * filter 接受lambda 从流里面排除元素
     * limit 流截断
     * skip(n) 返回一个跳过n个元素的流,前n个元素不要
     * distinct 通过流生成的元素的 hashCode()  equals() 去除重复
     */
    public static void test3() {
        l.stream().distinct().forEach(System.out::println);
    }

    public static void test2() {
        //内部迭代，迭代操作由Stream API完成。惰性求值
        try (Stream<Employee> emp = l.stream().filter(i ->
                {
                    System.out.println("中间操作");
                    return i.getAge() > 32;
                }
        )) {
            emp.forEach(System.out::println);
        }
        //外部迭代
        Iterator<Employee> t = l.iterator();
        while (t.hasNext()) {
            System.out.println(t.next());
        }
    }

    /**
     * 创建Stream 方式
     */
    public static void test1() {
        //Collection 系列里面的stream() 或 parallelStream()
        List<String> l1 = new ArrayList<>();
        Stream<String> stream = l1.stream();
        //Arrays.stream()
        String[] s = new String[2];
        Stream<String> stream1 = Arrays.stream(s);
        // Stream.of()
        Stream<String> stream2 = Stream.of("1", "6");
        //无限流创建
        //迭代  起始种子0   无限加1  limit限制多少个
        try (Stream<Integer> i = Stream.iterate(0, x -> x + 1)) {
            i.limit(5).forEach(System.out::println);
        }
        // 生成
        try (Stream<Double> g = Stream.generate(() -> Math.random())) {
            g.limit(3).forEach(System.out::println);
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    private String name;
    private Integer age;
    private Status status;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

@AllArgsConstructor
enum Status {
    FREE("空闲"),
    BUSY("繁忙"),
    VOCATION("哈哈");
    private String value;

    public String getValue() {
        return value;
    }
}

@Data
@NoArgsConstructor
class Menu {
    public Integer id;
    public String name;
    public Integer parentId;
    public List<Menu> childList;

    public Menu(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Menu(Integer id, String name, Integer parentId, List<Menu> childList) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.childList = childList;
    }
}