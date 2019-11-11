package com.java8;

/**
 * 继承的类和实现的接口有一样的方法时，类优先
 *支持 default方法  静态方法
 */
public class NewInterface {
    public static void main(String[] args) {
        I.MM();
        new Iip().test();
    }
}
class  Iip implements I{
    @Override
    public void hh() {
    }
}
interface I{
    default void test(){
        System.out.println(90);
    }
    static void MM(){
        System.out.println("我是哈哈,这个无法被实现");
    }
    void hh();
}