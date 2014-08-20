package com.umessage.algorithm.bubblesort;

import java.util.Arrays;

/**
 * 冒泡排序。从做至右依次比较，每次选出一个最大的交换到最右边的位置。
 * 
 * 使用do...while(true)循环代替以前外层的for循环。
 * 
 * 动画演示可以参考 http://www.comp.nus.edu.sg/~stevenha/visualization/index.html
 * 
 * @author licb
 * 
 */
public class BubbleSort {
	public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
		boolean swapFlag = false;
		do {
			// 如swapFlag在排序一次完毕后仍然是false，那么证明本次排序没有交换元素，那么排序结束。
			swapFlag = false;

			for (int i = 1; i < array.length; i++) {
				if (array[i - 1].compareTo(array[i]) > 0) {
					T tmp = array[i];
					array[i] = array[i - 1];
					array[i - 1] = tmp;

					swapFlag = true;
				}
			}
		} while (swapFlag);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] array = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50 };
		System.out.println("Source: " + Arrays.toString(array));

		BubbleSort.bubbleSort(array);

		System.out.println("Targer: " + Arrays.toString(array));
	}

}
