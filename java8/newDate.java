package com.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
/**
 * 线程安全
 *LocalDateTime LocalDate  LocalTime 不可变对象
 */
public class  newDate{

    public static void main(String[] args) {
        test7();
    }

    /**
     * 时区ZonedTime
     */
    public static void test7(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        //支持的时区有
       // availableZoneIds.forEach(System.out::println);
        //设置获取指定时区的 时间
        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("UTC"));
        System.out.println(dateTime);
    }
    /**
     * 格式转换
     */
    public static void test6(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String format = LocalDateTime.now().format(dtf);
        System.out.println(format);
        DateTimeFormatter.ofPattern("yyyyMMdd");//自定义格式
    }
    /**
     *时间矫正器 TemporalAdjuster
     */
    public static void test5(){
          LocalDateTime ldt =LocalDateTime.now();
          //设置当前日期 为这月的第二天
          LocalDateTime time = ldt.withDayOfMonth(2);
          System.out.println(time);
          LocalDateTime ad =LocalDateTime.now();
          //调整时间 TemporalAdjusters
          LocalDateTime with = ad.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
          System.out.println(with);
          //自定义调整
          LocalDateTime w1 = LocalDateTime.now().with(l -> {
            return l;
          });
          System.out.println(w1);
    }
    public static void test4(){
        Instant i1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant i2 = Instant.now();
        //Duration 求时间间隔   Period求 日期间隔
        Duration between = Duration.between(i1, i2);
        System.out.println(between.toMillis());
    }
    /**
     * Instant 时间戳  1970.01.01 00:00:00开始
     */
     public static void test3(){
         Instant now = Instant.now(); //默认时区 UTC
         System.out.println(now);
         //设置时区偏移量
         OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
         System.out.println(offsetDateTime);
         System.out.println("时间戳"+now.toEpochMilli());

         //使用从1970-01-01T00：00：00Z的时代开始的秒数(这里是0)获得一个 Instant的实例。
         Instant instant = Instant.ofEpochSecond(0);
         System.out.println(instant);

     }
    public static void test2(){
        LocalDateTime llt= LocalDateTime.now();
        System.out.println(llt);
        LocalDateTime ll= LocalDateTime.of(2060,01,01,0,0,10);
        System.out.println(ll);
        llt.plusYears(1);
        llt.minusDays(1);
        llt.getYear();
    }
    public static  void test1(){
        DateTimeFormatter dtm =DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> task = ()-> LocalDate.parse("20190123",dtm);

        ExecutorService pool =Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();
        for (int i=0;i<50;i++){
            results.add(pool.submit(task));
        }
        results.forEach(i->{
            try {
                System.out.println(i.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }
}
