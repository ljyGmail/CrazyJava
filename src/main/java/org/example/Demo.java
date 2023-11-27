package org.example;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        System.out.println("Arrays:");

        int[] arr = new int[]{1, 6, 13, 20, 24, 29, 53, 69, 78};
        int i = Arrays.binarySearch(arr, 20);
        System.out.println("Index of 20 in the arryay is " + i);
        int i2 = Arrays.binarySearch(arr, 2, 8, 20);
        System.out.println("Index of 20 in the arryay is " + i2);

        System.out.println(Arrays.toString(Arrays.copyOf(arr, 3)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 3, 6)));

        int[] arr2 = new int[]{1, 6, 13, 20, 24, 29, 53, 69, 78};
        int[] arr3 = new int[]{1, 6, 13, 20, 24, 29, 53, 69};

        System.out.println(Arrays.equals(arr, arr2));
        System.out.println(Arrays.equals(arr2, arr3));

        int[] arr4 = new int[3];
        System.out.println(Arrays.toString(arr4));
        Arrays.fill(arr4, 9);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {3, 6, 1, 4, 5, 9, 8};
        System.out.println(Arrays.toString(arr5));
        Arrays.sort(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {3, 6, 1, 4, 5, 9, 8};
        System.out.println(Arrays.toString(arr6));
        Arrays.sort(arr6,1, 5);
        System.out.println(Arrays.toString(arr6));

    }
}
