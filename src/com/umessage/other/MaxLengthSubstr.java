package com.umessage.other;

/**
 * 查找两个字符串中的最长公共子串。
 * 
 * 
 * 将两个字符串，一个横向按位排列，一个树向按位排列。如果横向和树向的两个字符相同，那么该位置的值填充为1，否则填充为0（
 * 实际上为最后倒序遍历二位数组查找最长子串计算方便， 如果某个位置需要填充为1时
 * ，这里填充的是该位置左上角的值+1。比如，如果(2,2)位置应该填充1，但是
 * (1,1)的值是2，那么(2,2)位置实际填充的为1+2=3。）。最后，最大的整数所在的对角线上，连续的值不为0的字符连接起来，就是最长子串。
 * 
 * 
 * @author licb
 * 
 */

public class MaxLengthSubstr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getLongestSubString();
	}

	public static void getLongestSubString() {
		// 两个需要对比的字符串
		String x = "abcdehpoi";
		String y = "bcdehfpoidfdegsfet";

		int substringLength1 = x.length();
		int substringLength2 = y.length();
		// 第一步：构造需要遍历的二位数组
		int opt[][] = new int[substringLength1 + 1][substringLength2 + 1];

		// 定义三个临时变量：最大值，最大值横坐标和竖坐标
		int max = opt[0][0];
		int xCoordinate = 0, yCoordinate = 0;

		// 第二步：横向竖向对比字符，填充上面构造的二位数组。
		for (int i = 1; i <= substringLength1; i++) {
			for (int j = 1; j <= substringLength2; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					// 横向和竖向的字符相同，改变改位置的值为左上角的值加1。
					opt[i][j] = opt[i - 1][j - 1] + 1;

					// 这里需要记录下最大值的值和坐标
					if (max < opt[i][j]) {
						max = opt[i][j];
						xCoordinate = i;
						yCoordinate = j;
					}
				}
			}
		}

		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("max = " + max);

		// 第四步：取出最大子串序列，并且展示。。。
		StringBuffer sb = new StringBuffer();
		for (int i = xCoordinate, j = yCoordinate; i >= 1 && j >= 1; i--, j--) {
			if (opt[i][j] > 0) {
				sb.append(x.charAt(i - 1));
			}
		}
		String result = sb.toString();
		// 上面的字符串是反的，这里反转输出结果
		for (int i = result.length() - 1; i >= 0; i--) {
			System.out.print(result.charAt(i));
		}
	}

}
