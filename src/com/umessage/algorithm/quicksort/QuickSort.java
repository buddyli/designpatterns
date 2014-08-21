package com.umessage.algorithm.quicksort;

import java.util.Arrays;

/**
 * 快速排序。
 * 
 * 步骤为：
 * 
 * 1,从数列中挑出一个元素，称为 "基准"（pivot）<br>
 * 
 * 2,重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边
 * ）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。<br>
 * 
 * 3,递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。<br>
 * 
 * 动画参考：http://www.comp.nus.edu.sg/~stevenha/visualization/sorting.html
 * 
 * 维基百科：http://zh.wikipedia.org/wiki/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F
 * 
 * @author licb
 * 
 */
public class QuickSort {

	/**
	 * 递归，递归，不要犯迷糊。
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	public static <T extends Comparable<? super T>> void recursiveQuickSort(T[] array, int left, int right) {
		if (right > left) {
			int partition = singleQuickSort(array, left, right);
			recursiveQuickSort(array, left, partition - 1);
			recursiveQuickSort(array, partition, right);
		}
	}

	/**
	 * 单趟排序。选取当前数组的第一个元素为pivot，从第二个元素开始遍历，如果当前元素小于pivot，那么依次追加到pivot后面。
	 * 最后返回storeIndex的值。以根据改值递归的遍历子partition。
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private static <T extends Comparable<? super T>> int singleQuickSort(T[] array, int left, int right) {
		// 假设未排序子序列的第一个元素为pivot
		T pivot = array[left];
		// 当前保存交换元素的位置
		int storeIndex = left + 1;

		for (int i = storeIndex; i < right; i++) {
			if (array[i].compareTo(pivot) < 0) {
				swap(array, i, storeIndex);

				storeIndex++;
			}

		}

		// 交换pivot和当前分区的最后的一个元素（当前分区的所有元素都应该是小于pivot的）
		swap(array, left, storeIndex - 1);

		return storeIndex;
	}

	private static <T extends Comparable<? super T>> void swap(T[] array, int _1st, int _2nd) {
		T tmp = array[_1st];
		array[_1st] = array[_2nd];
		array[_2nd] = tmp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] array = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50 };

		System.out.println("Source: " + Arrays.toString(array));
		QuickSort.recursiveQuickSort(array, 0, array.length - 1);
		System.out.println("Target: " + Arrays.toString(array));
	}

}
