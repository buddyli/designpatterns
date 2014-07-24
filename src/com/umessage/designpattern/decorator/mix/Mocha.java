package com.umessage.designpattern.decorator.mix;

import com.umessage.designpattern.decorator.Beverage;

/**
 * 摩卡添加剂。用来装饰添加摩卡的咖啡。
 * 
 * @author licb
 * 
 */
public class Mocha implements IDecorator {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public String description() {
		return beverage.description() + ", Mocha";
	}

	@Override
	public double cost() {
		return 0.25 + beverage.cost();
	}

}
