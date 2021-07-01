package com.ago.example.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ：Ago
 * @date ：Created in 2020/12/25 16:14
 * @description：
 * @modified By：
 * @version: $
 */
public class ThreadCompletion {

    private static volatile Integer index = 0;

    public static void main(String[] args) throws InterruptedException {


        List<FileItem> list = new ArrayList<>();

        list.add(new FileItem("zhangsan"));
        list.add(new FileItem("lisi"));
        list.add(new FileItem("ceshi"));
        list.add(new FileItem("wangwu"));
        list.add(new FileItem("dachui"));


        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch cdl = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            CountRunnable runnable = new CountRunnable(cdl, list, index);
            index++;
            pool.execute(runnable);
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CountRunnable implements Runnable {

        private Integer index;

        private volatile List<FileItem> list;

        private CountDownLatch countDownLatch;

        public CountRunnable(CountDownLatch cdl, List<FileItem> list, Integer index) {
            this.countDownLatch = cdl;
            this.list = list;
            this.index = index;
        }

        @SneakyThrows
        @Override
        public void run() {
            synchronized (countDownLatch) {
                countDownLatch.countDown();
                System.out.println(this.index);
                synchronized (list.get(index)) {
                    System.out.println(list.get(index));
                }
            }
        }
    }
}