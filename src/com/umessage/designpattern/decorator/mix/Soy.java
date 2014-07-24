package com.umessage.designpattern.decorator.mix;

import com.umessage.designpattern.decorator.Beverage;

/**
 * 豆浆添加剂。用来装饰添加豆浆的咖啡。
 * 
 * @author licb
 * 
 */
public class Soy implements IDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public String description() {
		return beverage.description() + ", Soy";
	}

	@Override
	public double cost() {
		return 0.15 + beverage.cost();
	}

}
