package com.umessage.designpattern.decorator;

import com.umessage.designpattern.decorator.coffee.BlackCoffee;
import com.umessage.designpattern.decorator.coffee.EspressoCoffee;
import com.umessage.designpattern.decorator.coffee.WhiteCoffee;
import com.umessage.designpattern.decorator.mix.Milk;
import com.umessage.designpattern.decorator.mix.Mocha;
import com.umessage.designpattern.decorator.mix.Soy;

/**
 * 装饰模式(Decorator)使用组合(composite)和委托(delegate)，有效的解决了由于类继承而带来的类爆炸问题。同时，
 * 可以动态的修改被装饰类的行为（本例子中 ，不同的咖啡通过被不同的佐料装饰，生成不同的价格）。
 * 
 * <p>
 * <strong>为了能够起到装饰的作用，装饰者和被装饰者必须是用一种类型的，如本例中，都继承自接口Beverage。</br>
 * 每个装饰者，都将被装饰者做为成员变量进行修饰。也就是说，需要接收被装饰者做为构造参数</strong>。
 * </p>
 * 
 * @author licb
 * 
 */
public class DecoratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 一杯意式浓缩咖啡，不加任何调料，那么不需要任何佐料修饰。
		Beverage espresso = new EspressoCoffee();// 1.5
		System.out.println(espresso.description() + ", " + espresso.cost());

		// 摩卡豆浆牛奶白咖啡：一杯白咖啡，由一份摩卡、一份豆浆和一份牛奶来修饰
		Beverage espresso2 = new WhiteCoffee();// 1.3
		espresso2 = new Mocha(espresso2);// .25
		espresso2 = new Soy(espresso2);// .15
		espresso2 = new Milk(espresso2);// .1
		System.out.println(espresso2.description() + ", " + espresso2.cost());

		// 摩卡摩卡牛奶黑咖啡：一杯黑咖啡，由两份摩卡、一份牛奶来修饰
		Beverage espresso3 = new BlackCoffee();// 1.0
		espresso3 = new Mocha(espresso3);// .25
		espresso3 = new Mocha(espresso3);// .25
		espresso3 = new Milk(espresso3);// .1
		System.out.println(espresso3.description() + ", " + espresso3.cost());
	}

}
