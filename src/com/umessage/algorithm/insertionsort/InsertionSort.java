package com.umessage.algorithm.insertionsort;

import java.util.Arrays;

/**
 * 插入排序，时间复杂度为O(N^2)，如果源数组是预先排序好的，那么时间复杂度为O(N)。
 * 
 * 插入排序由N-1趟<strong>(不是N-1次)</strong>排序组成。对于p=1到N-1，插入排序保证从位置0到p上的元素为已排序状态。
 * 
 * 插入排序利用了这样的事实：已知位置0到位置p-1上的元素已经处于排过序的状态。
 * 
 * @author licb
 * 
 */
public class InsertionSort {

	/**
	 * 
	 * @param array
	 *            要排序的Comparable源数组
	 */
	public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
		int j;

		// 第p趟，将位置p上的元素向左移动，直到在它前p+1个元素中的正确位置被找到的地方(注意：p是从1开始的)。
		for (int p = 1; p < array.length; p++) {

			// 27-33行实现数据移动而没有明显的试用交换
			T tmp = array[p];

			for (j = p; j > 0 && tmp.compareTo(array[j - 1]) < 0; j--) {// 如果源数组是有序的，这么这里的子逻辑不会执行，因为第二个compare条件不满足。
				array[j] = array[j - 1];
			}

			array[j] = tmp;
		}
	}

	public static void main(String[] args) {
		Integer[] array = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50 };

		System.out.println("Source: " + Arrays.toString(array));
		insertionSort(array);
		System.out.println("Target: " + Arrays.toString(array));
	}
}
