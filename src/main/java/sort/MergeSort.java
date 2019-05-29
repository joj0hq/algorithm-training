package sort;

import java.util.Arrays;

public class MergeSort {
    private static int[] array = {4, 6, 3, 6, 8, 1, 3, 9, 0};

    public static void main(String[] args) {
        sort(array);
    }

    private static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        sort(arr, temp, left, right);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int[] temp, int left, int right) {
        if(left < right) {
            int mid = (right + left) / 2;
            sort(arr, temp, left, mid);
            sort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int leftMinPoint = left;
        int rightMinPoint = mid + 1;
        for (int k = left; k < right; k++) {
            // target != R or L min
            if (arr[k] > arr[leftMinPoint]) { // target > left min
                temp[k] = arr[rightMinPoint++];
            } else if (arr[k] > arr[rightMinPoint]) { // target > right min
                temp[k] = arr[leftMinPoint++];

                // target = R or L min
            } else if (arr[leftMinPoint] < arr[rightMinPoint]) { // right min > left min
                temp[k] = arr[leftMinPoint++];
            } else {
                temp[k] = arr[rightMinPoint++];
            }
        }
        for (int k = left; k < right; k++) {
            arr[k] = temp[k];
        }
    }
}
