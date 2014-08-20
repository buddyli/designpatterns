package com.umessage.algorithm.selection;

import java.util.Arrays;

/**
 * 选择排序，每次循环找出一个最小的，填充到最左第一个还没有排序的位置。
 * 
 * @author licb
 * 
 */
public class SelectionSort {

	public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
		for (int i = 0; i < array.length; i++) {
			// step1: 初始默认最小值为当前元素
			T min = array[i];

			// step2: 从剩余的未排序的序列中找出最小值
			int newMinIndex = 0;
			for (int j = i + 1; j < array.length; j++) {
				if (min.compareTo(array[j]) > 0) {
					newMinIndex = j;
					min = array[j];
				}
			}

			// step3: 将第二步找到的最小值与当前序列中最左位置第一个无序的元素交换。
			if (min != array[i]) {
				T tmp = array[i];
				array[i] = min;
				array[newMinIndex] = tmp;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] array = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50 };
		System.out.println("Source: " + Arrays.toString(array));

		selectionSort(array);

		System.out.println("Target: " + Arrays.toString(array));

	}

}
