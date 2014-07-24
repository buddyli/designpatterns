package com.umessage.designpattern.decorator.coffee;

import com.umessage.designpattern.decorator.Beverage;

public class BlackCoffee implements Beverage {

	@Override
	public String description() {
		return "BlackCoffee";
	}

	@Override
	public double cost() {
		return 1.0;
	}

}
