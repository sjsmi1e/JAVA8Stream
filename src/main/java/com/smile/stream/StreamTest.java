package com.smile.stream;


import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by smi1e
 * Date 2019/6/20 21:18
 * Description lambda与stream练习
 */

public class StreamTest {


    List<Integer> getList(int n, Supplier<Integer> f) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            Integer integer = f.get() + i;
            list.add(integer);
        }
        return list;
    }

    /**
     * 平方
     * map一般返回一个集合，reduce一般返回一个值
     */
    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 31; i++) {
            list.add(i);
        }
        System.out.println(list);

        List<Integer> collect = list.stream().map((x) -> x * x).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 提取偶数在平方,求和
     */
    @Test
    public void test2() {
        List<Integer> list = getList(31, () -> 0);
        System.out.println(list);
        Optional<Integer> sum = list.stream().filter((x) -> x % 2 == 0).map((x) -> x * 2).reduce((x, y) -> x + y);
        System.out.println(sum.get());
    }

    /**
     * 自然排序和自定义排序
     */
    @Test
    public void test3(){
        List<Integer> list = getList(31,()->(int) (Math.random()*100));
        System.out.println(list);
        //自然排序
        System.out.println(list.stream().sorted().collect(Collectors.toList()));
        //倒序
        System.out.println(
                list.stream().sorted((x,y)->- Integer.compare(x,y)).collect(Collectors.toList())
        );
        /**
         * 字符串比较
         */
        String[] strs = {"asasa",
                        "sasasa",
                        "fdfde",
                        "kijsdain",
                        "duubfsdbhsd"
        };
        System.out.println(
                Arrays.stream(strs).sorted().collect(Collectors.toList())
        );
        System.out.println(
                Arrays.stream(strs).sorted((x,y)->-x.compareTo(y)).collect(Collectors.toList())
        );







    }
}
