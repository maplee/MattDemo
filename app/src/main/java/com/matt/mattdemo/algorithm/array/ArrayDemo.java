package com.matt.mattdemo.algorithm.array;

/**
 */
public class ArrayDemo {


    public static int getShowMin(int[] intArray) {
        int result = 0;
        for (int i = 0; i < intArray.length; i++) {
            result ^= intArray[i];
            System.out.println(result);
        }
        return result;
    }

    private static int findIndex(int[] findArray, int target) {
        int low = 0;
        int high = findArray.length - 1;
        int middle = 0;
        int value = 0;
        if (target < findArray[low] || target > findArray[high]) {
            return -1;
        }
        while (low <= high) {
            middle = (low + high) >> 1;
            value = findArray[middle];
            if (value < target) {
                low = middle + 1;
            } else if (value > target) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String... args) {
//        int[] intArray = {1, 8, 1, 2, 9, 2, 3, 4, 3, 4, 5, 5, 6, 6, 7, 7, 8, 7};
//        System.out.println(getShowMin(intArray));
//        System.out.println("1^1:" + (1 ^ 1));
//        System.out.println("1^2:" + (1 ^ 2));
//        System.out.println("1^3:" + (1 ^ 3));
//        System.out.println("1^4:" + (1 ^ 4));
//        System.out.println("1^5:" + (1 ^ 5));
//        System.out.println("1^0:" + (1 ^ 0));
//        System.out.println("----------");
//
//        System.out.println("1|1:" + (1 | 1));
//        System.out.println("1|2:" + (1 | 2));
//        System.out.println("1|3:" + (1 | 3));
//        System.out.println("1|4:" + (1 | 4));
//        System.out.println("5|5:" + (1 | 5));
//        System.out.println("6|6:" + (6 | 6));
//        System.out.println("6|7:" + (6 | 7));
//        System.out.println("7|7:" + (7 | 7));
//        System.out.println("7|8:" + (7 | 8));
//        System.out.println("1|0:" + (1 | 0));

        System.out.println("二分查找:");
        int[] findArray = {1, 4, 5, 7, 9, 10};
        int findResult = findIndex(findArray, 5);
        System.out.println("findResult:" + findResult);
        System.out.println("10>>>2:" + (10>>1));
    }
}
