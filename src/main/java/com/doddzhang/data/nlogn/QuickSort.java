package com.doddzhang.data.nlogn;

/**
 * 快速排序
 *
 * @author doddzhang
 */
public class QuickSort {

    /**
     * 交换数组中指定两个下标的值
     *
     * @param num
     * @param left
     * @param right
     */
    public static void swap(int[] num, int left, int right) {
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }

    /**
     * 获取数组中的pivot下标
     *
     * @param num
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] num, int left, int right) {
        // 参数校验
        if (null == num || 0 == num.length || left < 0 || right > num.length - 1) {
            return 0;
        }

        // 获取pivot的值
        int pivot = num[left + (right - left) / 2];

        while (left <= right) {

            // 移动左指针，直到找到大于pivot的值，停下指针等待交换
            while (num[left] < pivot) left++;

            // 移动右指针，直到找到小于pivot的值，停下指针等待交换
            while (num[right] > pivot) right--;

            // 交换左右两个指针的数值
            if (left <= right) {
                swap(num, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    /**
     * 递归方式实现快排
     *
     * @param num
     * @param left
     * @param right
     */
    public static void sort(int[] num, int left, int right) {
        // 递推公式的结束条件
        if (left < right) {
            int pivot = partition(num, left, right);
            QuickSort.sort(num, left, pivot - 1);
            QuickSort.sort(num, pivot, right);
        }
    }


    public static void main(String[] args) {
        int[] test = {2, 44, 66, 45, 75, 3, 54, 8, 7, 99, 0, 8, 678, 12};
        QuickSort.sort(test, 0, test.length - 1);
        for (int i : test) {
            System.out.println(i);
        }
    }
}
