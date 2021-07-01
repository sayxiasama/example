package com.ago.example.exercise.search;

import java.math.BigDecimal;

/**
 * @author ：Ago
 * @date ：Created in 2021/1/13 15:11
 * @description：
 * @modified By：
 * @version: $
 */
public class Practice {


    public static void main(String[] args) {


        int[] ints = {4, 7, 2, 9, 9, 9, 9};

//        int i = binarySearch(ints, ints.length, 12);

//        int i = binarySearch(ints, 0, ints.length - 1, 0);

//        System.out.println(i + ":" + (i == -1 ? -1 : ints[i]));

//        Double square = square(5);

//        System.out.print(square);

//        int firstElement = findFirstElement(ints, ints.length, 9);

//        int lastElement = findLastElement(ints, ints.length, 9);

//        System.out.println(firstElement);

//        System.out.println(lastElement);

//        int firstGtElement = findFirstGtElement(ints, ints.length, 5);

//        System.out.println(firstGtElement);


        int lastLtElement = findLastLtElement(ints, ints.length, 12);
        System.out.println(lastLtElement);
    }


    public static int binarySearch(int[] arr, int n, int val) {

        int low = 0;
        int high = n - 1;


        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (arr[mid] == val) {
                return mid;
            }

            if (arr[mid] < val) {

                low = mid + 1;
            } else {

                high = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int low, int high, int val) {

        if (low > high) return -1;

        int mid = low + ((high - low) >> 1);

        if (arr[mid] == val) {
            return mid;
        }

        if (arr[mid] < val) {
            return binarySearch(arr, mid + 1, high, val);
        } else {
            return binarySearch(arr, low, mid - 1, val);
        }
    }


    public static Double square(int s) {

        double q = 0;

        double low = 0;

        double high = s;

        while (low <= high) {

            q = (high + low) / 2;

            if (q * q > s) {

                high = q - 0.000001;
            } else if (q * q < s) {
                low = q + 0.000001;
            }
        }


        return new BigDecimal(q).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static int findFirstElement(int arr[], int n, int val) {

        int low = 0;

        int high = n - 1;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (arr[mid] >= val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < n && arr[low] == val) {
            return low;
        } else {
            return -1;
        }
    }

    public static int findLastElement(int arr[], int n, int val) {

        int low = 0;

        int high = n - 1;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

//            if (arr[mid] > val) {
//                high = mid - 1;
//            } else if (arr[mid] < val) {
//                low = mid + 1;
//            } else {
//
//                if ((mid == n - 1) || (arr[mid + 1] != val)) {
//                    return mid;
//                } else {
//                    low = mid + 1;
//                }
//
//            }
//        }
//
//        return -1;


            if (arr[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }


        if ((high == n - 1) || arr[high + 1] != val) {
            return high;
        } else {
            return -1;
        }
    }


    public static int findFirstGtElement(int[] arr, int n, int val) {

        int low = 0;

        int high = n - 1;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);


            if (arr[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < n && arr[low - 1] < val) {
            return low;
        } else {
            return -1;
        }
    }


    public static int findLastLtElement(int[] arr, int n, int val) {

        int low = 0;

        int high = n - 1;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (arr[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (high == n - 1 || arr[high + 1] > val) {
            return high;
        } else {
            return -1;
        }
    }
}
