package com.umessage.algorithm.shellsort;

import java.util.Arrays;

/**
 * 希尔排序，冲破二次时间屏障的第一批算法之一。通过合理的选择增量序列，时间复杂度可以达到O(N^4/3)或者O(N^7/6)。
 * 
 * 因为每趟比较所用的距离随着算法的进行而减小，直到只比较相邻元素的最后一趟排序为止。因此有时也叫做缩减增量排序（diminishing increment
 * sort）。
 * 
 * 增量序列的一个流行的选择方式是：N/2的下界，下一个增量为上一个增量的/2下界。
 * 
 * @author licb
 * 
 */
public class ShellSort {

	public static <T extends Comparable<? super T>> void shellSort(T[] array) {
		int j;

		// 选择增量为数组长度的1/2的下界。
		for (int gap = array.length / 2; gap > 0; gap /= 2) {

			// 从gap开始，对相隔gap个位置的元素进行排序
			for (int i = gap; i < array.length; i++) {
				T tmp = array[i];

				for (j = i; j >= gap && tmp.compareTo(array[j - gap]) < 0; j -= gap) {
					array[j] = array[j - gap];
				}

				array[j] = tmp;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] array = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50 };

		System.out.println("Source: " + Arrays.toString(array));
		shellSort(array);
		System.out.println("Target: " + Arrays.toString(array));
	}

}
