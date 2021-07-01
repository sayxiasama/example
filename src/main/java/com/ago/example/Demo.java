package com.ago.example;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author ：Ago
 * @date ：Created in 2021/1/20 16:12
 * @description：
 * @modified By：
 * @version: $
 */
public class Demo {


    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量
    private boolean[][] mem = new boolean[5][10]; // 备忘录,默认值false


    public void f(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了,i==n表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }
        if (mem[i][cw]) return; // 重复状态
        mem[i][cw] = true; // 记录(i, cw)这个状态
        f(i + 1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // 选择装第i个物品
        }
    }


    /**
     * 通过交换a,b中的元素,使[序列a元素的和]与[序列b元素的和]之间的差最小
     * <p>
     * int[] a = new int[]{5,5,9,9,1};
     * <p>
     * int[] b = new int[]{4,7,7,8,5};
     *
     * @param args ideas:
     *             1. 求两数组和 取出 sum/2;
     *             2. 找出两个数组中 m个元素 使得m个元素和接近sum/2
     *             3. 找出m个元素后, 在所有元素中进行分配.
     */
    public static void main(String[] args) {

        int before = 0; // 上一次与mid相差的绝对值

        int difference = 0; // 当前与mid差的绝对值

        int total = 0; //当前所选元素总和

        int[] a = new int[]{5, 5, 9, 9, 1};
        int[] b = new int[]{4, 7, 7, 8, 5};

        int mid = sum(a, b) >> 1;  //数组和平均值


        int[] merge = merge(a, b); //合并数组元素

        difference = Math.abs(total - mid);


        // 在merge中选出n个元素使得 n个元素和最接近mid 且n = a.length || b.length


    }


    public static Integer sum(int[] a, int[] b) {


        int reduce = Arrays.stream(a).reduce(0, (x, y) -> x + y);


        int reduce1 = Arrays.stream(b).reduce(0, (x, y) -> x + y);

        System.out.println(reduce + reduce1);

        return reduce + reduce1;
    }

    public static int[] merge(int[] a, int[] b) {


        int[] merge = Arrays.copyOf(a, a.length + b.length);


        for (int i = 0; i < b.length; i++) {

            merge[a.length + i] = b[i];
        }

        Arrays.stream(merge).forEach(System.out::println);

        return merge;

    }
}
