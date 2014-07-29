package com.umessage.other;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 输出当前月份的日历
 * 
 * @author licb
 * 
 */
public class CalendarTest {

	/**
	 * @param args
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		// 日,一,二,三,四,五,六
		String[] strCal = new String[42];
		String[] destCal = new String[35];
		// 只需要保存第一行的Calendar对象就可以了。
		Calendar[] calArr = new Calendar[7];

		Calendar cal = Calendar.getInstance();
		// cal.set(Calendar.YEAR, 2014);
		// cal.set(Calendar.MONTH, Calendar.JULY);

		cal.set(Calendar.DAY_OF_MONTH, 1);

		// 周,1-7的整数，1为周日，7为周六
		int dw = cal.get(Calendar.DAY_OF_WEEK);
		int startIndex = dw - 1;
		strCal[startIndex] = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		calArr[startIndex] = (Calendar) BeanUtils.cloneBean(cal);

		// 填充第一行当前日期之前的内容
		for (int i = 0; i < startIndex; i++) {
			Calendar tmp = (Calendar) BeanUtils.cloneBean(calArr[startIndex]);
			tmp.add(Calendar.DAY_OF_MONTH, 0 - (startIndex - i));
			calArr[i] = (Calendar) BeanUtils.cloneBean(tmp);
			strCal[i] = String.valueOf(calArr[i].get(Calendar.DAY_OF_MONTH));

		}

		// 填充第一行当前日期之后的内容
		for (int i = 6; i > startIndex; i--) {
			Calendar tmp = (Calendar) BeanUtils.cloneBean(calArr[startIndex]);
			tmp.add(Calendar.DAY_OF_MONTH, i - startIndex);
			strCal[i] = String.valueOf(tmp.get(Calendar.DAY_OF_MONTH));
			calArr[i] = (Calendar) BeanUtils.cloneBean(tmp);
		}

		// 填充每一列
		for (int i = 0; i < 7; i++) {
			Calendar tmpCal = calArr[i];

			for (int j = 1; j < strCal.length / 7; j++) {
				tmpCal.add(Calendar.DAY_OF_MONTH, j * 7);
				strCal[j * 7 + i] = String.valueOf(tmpCal.get(Calendar.DAY_OF_MONTH));

				tmpCal.add(Calendar.DAY_OF_MONTH, 0 - j * 7);
			}
		}

		// 处理日历需要5行显式还是6行显式的问题
		int lastDay = Integer.parseInt(strCal[strCal.length - 8]);
		if (lastDay >= 29 && lastDay < Calendar.getInstance().getMaximum(Calendar.DAY_OF_MONTH)) {
			destCal = strCal;
		} else {
			System.arraycopy(strCal, 0, destCal, 0, destCal.length);
		}

		int num = 0;
		System.out.println("日,一,二,三,四,五,六");
		for (String item : destCal) {
			num++;
			System.out.print(item);

			if (num != 0 && num % 7 == 0) {
				System.out.println();
			} else {
				System.out.print(",");
			}

		}
	}
}
