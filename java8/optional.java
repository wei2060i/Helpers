package com.generator.controller;

import java.util.Optional;

public class optional {

    public static void main(String[] args) throws Exception {
        test2();
    }

    /**
     * Optional.of(T t)创建一个Optional实例
     * Optional.empty() 创建空的Optional实例
     * Optional.ofNullable(T t) T是null创建空的Optional实例，否则创建Optional实例
     * Optional.isPresent()是否包含值
     * Optional.ofNullable(new Employee()).ifPresent(e -> { 不是null TODO });
     * Optional.ofNullable().orElse(T t) 如果调用对象有值直接返回值，否则(创建op时 传入的是null)返回t
     * Optional.ofNullable().orElseGet(Supplier s)  如果调用对象有值直接返回值,否则返回s.get()
     * Optional.ofNullable(null).orElseThrow(()->new Exception("用户不存在"));
     * Optional.map(function f) 有值，就返回Optional实例  否则Optional.empty()
     * Optional.flatMap(Function f) 有值，就返回Optional实例  否则Optional.empty()
     * Optional.filter() 满足条件 返回此Optional
     */
    private static void test4() {
        Optional<Employee> op = Optional.ofNullable(new Employee("阿三", 12));
        Optional<String> str = op.map(e -> e.getName());
        System.out.println(op + ".........." + str);
        Optional<Integer> i = op.flatMap(value -> Optional.of(value.getAge()));
        System.out.println(i);
    }

    private static void test3() {
        Optional<Object> op = Optional.empty();
        System.out.println(op);
    }

    private static void test2() {
        Optional<Object> op = Optional.ofNullable(new Employee());
        System.out.println(op);
        System.out.println(op.isPresent());
        System.out.println(op.orElse(new Employee()));
        Employee employee = (Employee) op.orElseGet(() -> new Employee("小屋", 12));
        System.out.println(employee);
    }

    public static void test1() {
        Optional<Object> op = Optional.of(null);
        System.out.println(op.get());
    }
}