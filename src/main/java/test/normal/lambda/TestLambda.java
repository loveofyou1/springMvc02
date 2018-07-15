package test.normal.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * lambda新特性学习
 *
 * @author sunlei19
 * @create 2018/7/13
 **/
public class TestLambda {

    public static void main(String[] args) {
        innerClass();

        lambda();

        System.out.println(doPredicate(14, x -> x >= 18));

        donation(30, money -> System.out.println("dean buy beer cost " + money + "$."));

        List<Integer> list = doSupply(10, () -> (int) Math.random() * 100);

        list.forEach(System.out::println);

        System.out.println(convert("100", x -> Integer.parseInt(x)));

        List<String> frults = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        List<String> newFrults = filter(frults, (f) -> f.length() == 2);
        newFrults.forEach(System.out::println);

        List<Integer> needSortlist = Arrays.asList(2, 7, 3, 1, 8, 6, 4);
        needSortlist.sort(Comparator.naturalOrder());
        needSortlist.forEach(System.out::println);
    }

    /**
     * 使用内部类实现打印字符串
     */
    private static void innerClass() {
        try {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("inner Class");
                }
            };
            runnable.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 使用lambda方式
     */
    private static void lambda() {
        try {
            Runnable run = () -> System.out.println("lambda ");
            run.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 函数式接口
     *
     * @param <T>
     */
    interface Predicate<T> {
        boolean test(T t);
    }

    /**
     * 执行Predicate判断,判断是否成年
     *
     * @param age       年龄
     * @param predicate 函数接口对象
     * @return
     */
    public static boolean doPredicate(int age, Predicate<Integer> predicate) {
        return predicate.test(age);
    }


    /**
     * 消费型接口示例
     * 打印出所花费金额
     *
     * @param money   金额
     * @param cusumer 消费接口
     */
    public static void donation(int money, Consumer<Integer> cusumer) {
        cusumer.accept(money);
    }


    /**
     * 供给型接口示例
     * <br>
     * 生成随机数
     *
     * @param num      数量
     * @param supplier 供给接口
     * @return
     */
    public static List<Integer> doSupply(Integer num, Supplier<Integer> supplier) {
        List<Integer> reList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            reList.add(supplier.get());
        }
        return reList;
    }


    /**
     * 函数型接口示例
     * <br>
     * 字符串转换成integer
     *
     * @param str      需处理字符串
     * @param function 函数型接口
     * @return
     */
    public static Integer convert(String str, Function<String, Integer> function) {
        return function.apply(str);
    }


    /**
     * 断言型接口示例
     * <br>
     * 筛选出只有2个字的水果
     *
     * @param fruit     水果列表
     * @param predicate 断言型接口
     * @return
     */
    public static List<String> filter(List<String> fruit, java.util.function.Predicate<String> predicate) {
        List<String> resultList = new ArrayList<>();
        for (String s : fruit) {
            if (predicate.test(s)) {
                resultList.add(s);
            }
        }
        return resultList;
    }
}
