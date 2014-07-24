package com.umessage.designpattern.decorator.coffee;

import com.umessage.designpattern.decorator.Beverage;

public class WhiteCoffee implements Beverage {

	@Override
	public String description() {
		return "WhiteCoffee";
	}

	@Override
	public double cost() {
		return 1.3;
	}

}
