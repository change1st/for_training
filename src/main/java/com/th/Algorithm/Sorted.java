package com.th.Algorithm;

public class Sorted {
    private static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int[] mergeSort(int[] arr, int left, int right) {
        if (right - left < 1) {
            int[] mergeArr = new int[1];
            mergeArr[0] = arr[left];
            return mergeArr;
        }

        int mid = (left + right) / 2;
        return merge(mergeSort(arr, left, mid), mergeSort(arr, mid + 1, right));
    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        int leftLen = leftArr.length;
        int rightLen = rightArr.length;
        int[] arr = new int[leftLen + rightLen];

        int left = 0;
        int right = 0;
        while (left < leftLen && right < rightLen) {
            if (leftArr[left] < rightArr[right]) {
                arr[left + right] = leftArr[left];
                left++;
            } else {
                arr[left + right] = rightArr[right];
                right++;
            }
        }

        if (left == leftLen) {
            for (; right < rightLen; right++) {
                arr[left + right] = rightArr[right];
            }
        }

        if (right == rightLen) {
            for (; left < leftLen; left++) {
                arr[right + left] = leftArr[left];
            }
        }

        return arr;
    }

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = arr.length; i > 0; i--) {
            for (int j = i / 2 - 1; j >= 0; j--) {
                int left = 2 * j + 1;
                int right = 2 * j + 2;
                int max = arr[j];
                if (left <= i - 1) {
                    if (arr[left] > arr[j]) {
                        int temp = arr[left];
                        arr[left] = max;
                        max = temp;
                    }
                }

                if (right <= i - 1) {
                    if (arr[right] > arr[j]) {
                        int temp = arr[right];
                        arr[right] = max;
                        max = temp;
                    }
                }

                arr[j] = max;
            }
            int temp = arr[0];
            arr[0] = arr[i - 1];
            arr[i - 1] = temp;
        }
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int flag = arr[left];
        while (left < right) {
            while (arr[right] > flag && left < right) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
                left++;
            }

            while (arr[left] <= flag && left < right) {
                left++;
            }

            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = flag;

        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {8, 11, 12, 13, 6, 10, 14, 1, 3, 5, 7, 9, 4, 2, 15};
//        quickSort(arr);
//        heapSort(arr);
        int[] mergeSort = mergeSort(arr);
        int len = mergeSort == null ? 0 : mergeSort.length;
        for (int i = 0; i < len; i++) {
            System.out.print(mergeSort[i]);
            System.out.print(" ");
        }
    }
}
