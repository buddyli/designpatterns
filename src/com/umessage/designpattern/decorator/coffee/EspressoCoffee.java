package com.umessage.designpattern.decorator.coffee;

import com.umessage.designpattern.decorator.Beverage;

public class EspressoCoffee implements Beverage {

	@Override
	public String description() {
		return "EspressoCoffee";
	}

	@Override
	public double cost() {
		return 1.5;
	}

}
