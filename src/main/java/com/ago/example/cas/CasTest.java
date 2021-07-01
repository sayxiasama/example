package com.ago.example.cas;

import org.springframework.util.CollectionUtils;
import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：Ago
 * @date ：Created in 2021/3/25 14:58
 * @description：
 * @modified By：
 * @version: $
 */
public class CasTest {


    private AtomicInteger num;

    private static final ReentrantLock lock = new ReentrantLock(true);


    public void test() {

        try {
            lock.lock();
            System.out.println(2222);
            System.out.println("current  execute  thread name :" + Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public static void main(String[] args) {

        ArrayList<Object> list = new ArrayList<>();


        if (!CollectionUtils.isEmpty(list)) {
            System.out.println("hhh");
        }

    }
}
