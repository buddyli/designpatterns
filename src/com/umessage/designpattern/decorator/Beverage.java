package com.umessage.designpattern.decorator;

/**
 * 饮料接口
 * 
 * @author licb
 * 
 */
public interface Beverage {
	/**
	 * 饮料描述
	 * 
	 * @return
	 */
	String description();

	/**
	 * 饮料价格
	 * 
	 * @return
	 */
	double cost();
}
