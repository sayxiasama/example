package com.ago.example.exercise.sort;

import org.springframework.util.StopWatch;

/**
 * @author ：Ago
 * @date ：Created in 2021/1/7 15:41
 * @description：
 * @modified By：
 * @version: $
 */
public class Practice {


    public static void main(String[] args) throws InterruptedException {

        int[] ints = {9, 4, 1, 6, 3, 6, 2};
//        Arrays.stream(bubbleShort(ints, ints.length)).forEach(System.out::println);

//        Arrays.stream(insertionSort(ints, ints.length)).forEach(System.out::println);

//        Arrays.stream(selectSort(ints, ints.length)).forEach(System.out::println);

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        Thread.sleep(3000);

        stopWatch.stop();

        System.out.println(stopWatch.getTotalTimeMillis());


    }


    public static int[] bucketSort(int[] arr, int n) throws InterruptedException {


        return null;
    }


    public static int[] bubbleShort(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            boolean s = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];

                    arr[j] = arr[j + 1];

                    arr[j + 1] = temp;

                    s = true;
                }
            }

            if (!s) break;
        }

        return arr;
    }

    public static int[] insertionSort(int[] arr, int n) {

        for (int i = 0; i < n; i++) {

            int value = arr[i];

            int j = i - 1;

            for (; j >= 0; j--) {

                if (arr[j] > value) {

                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = value;

        }

        return arr;
    }


    public static int[] selectSort(int[] arr, int n) {

        for (int i = 0; i < n; i++) {

            int k = i;

            for (int j = k + 1; j < n; j++) {

                if (arr[j] < arr[k]) {
                    k = j;
                }
            }

            if (i != k) {

                int temp = arr[i];

                arr[i] = arr[k];

                arr[k] = temp;

            }
        }

        return arr;
    }

}



