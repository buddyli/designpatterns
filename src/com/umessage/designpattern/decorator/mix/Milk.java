package com.umessage.designpattern.decorator.mix;

import com.umessage.designpattern.decorator.Beverage;

/**
 * 牛奶添加剂。用来装饰添加牛奶的咖啡。
 * 
 * @author licb
 * 
 */
public class Milk implements IDecorator {
	Beverage beverage;

	public Milk(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public String description() {
		return beverage.description() + ", Milk";
	}

	@Override
	public double cost() {
		return 0.1 + beverage.cost();
	}

}
