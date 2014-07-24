package com.umessage.algorithm.mergesort;

/**
 * 归并排序，递归的经典使用。最大时间复杂度O(NlogN)
 * 
 * @author licb
 * 
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// source array
		int[] source = { 8, 7, 34, 12, 323, 56, 76, 86, 45, 90 };
		// temporary array, to store sorted values in each sub merge.
		int[] tmpArray = new int[source.length];

		System.out.println(source);
		cycleMerge(source, tmpArray, 0, source.length - 1);
		System.out.println(source);
	}

	private static void merge(int[] source, int[] tmpArray, int left, int middle, int right) {
		int leftEnd = middle - 1;// 左字数组最后一个变量的下标
		int tmpIndex = 0;// 临时数组保存变量的起始位置
		int n = right - left + 1;// 临时数组保存的变量个数
		int leftLow = left;// 本次排序最左下标在源数组中的位置

		// while(left <= leftEnd && middle <= right)
		for (; left <= leftEnd && middle <= right;) {
			if (source[left] <= source[middle]) {
				tmpArray[tmpIndex++] = source[left++];

			} else {
				tmpArray[tmpIndex++] = source[middle++];

			}
		}

		// 如果左子数组有剩余，那么依次追加到临时数组末尾
		while (left <= leftEnd) {
			tmpArray[tmpIndex++] = source[left++];
		}
		// 如果右子数组有剩余，那么依次追加到临时数组末尾
		while (middle <= right) {
			tmpArray[tmpIndex++] = source[middle++];
		}

		// 将排序后的内容按照次序保存到源数组中
		for (tmpIndex = 0; tmpIndex < n; tmpIndex++) {
			source[leftLow + tmpIndex] = tmpArray[tmpIndex];
		}
	}

	private static void cycleMerge(int[] source, int[] tmpArray, int startIndex, int endIndex) {
		if (startIndex == endIndex) {// 空数组不用排序
			return;
		} else {
			// 递归对子数组进行排序
			int middle = (startIndex + endIndex) / 2;
			cycleMerge(source, tmpArray, startIndex, middle);
			cycleMerge(source, tmpArray, middle + 1, endIndex);
			// 执行真正排序
			merge(source, tmpArray, startIndex, middle + 1, endIndex);
		}

	}
}
