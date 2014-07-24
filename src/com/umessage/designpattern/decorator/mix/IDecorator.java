package com.umessage.designpattern.decorator.mix;

import com.umessage.designpattern.decorator.Beverage;

/**
 * 所有装饰者的基类。因为这个接口继承Beverage接口，因此装饰者和被装饰者都是Beverage类型的。
 * 
 * @author licb
 * 
 */
public interface IDecorator extends Beverage {

}
