package com.ago.example.template;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @author ：Ago
 * @date ：Created in 2021/1/20 15:51
 * @description：
 * @modified By：
 * @version: $
 */
public class TemplateDis {


    public static void main(String[] args) {


        HashSet<String> a = new HashSet<>();

        a.add("1");

        a.add("2");


        HashSet<Object> b = new HashSet<>();

        b.add("1");


        a.stream().filter(x -> !b.contains(x)).forEach(System.out::println);

    }

}
