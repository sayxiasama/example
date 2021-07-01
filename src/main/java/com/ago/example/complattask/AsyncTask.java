package com.ago.example.complattask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.logging.SimpleFormatter;

/**
 * @author ：Ago
 * @date ：Created in 2020/12/17 10:35
 * @description：测试
 * @modified By：
 * @version: $
 */
public class AsyncTask {


    public static void main(String[] args) throws ExecutionException, InterruptedException, ParseException {


        String s = taskReturn(2);
        System.out.println(s);
    }


    public static String taskReturn(Integer arg) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletionService<String> service = new ExecutorCompletionService(executorService);


        if (arg == 1) {
            service.submit(() -> {
                System.out.println("this arg is one");
            }, "one success");
        }

        if (arg == 2) {
            service.submit(() -> {
                System.out.println("this arg is two");
            }, "two success");
        }

        executorService.shutdown();

        return service.take().get();
    }
}
