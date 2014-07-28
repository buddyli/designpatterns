package com.umessage.designpattern.proxy;

import java.lang.reflect.Proxy;

import com.umessage.designpattern.proxy.bean.PersonBean;
import com.umessage.designpattern.proxy.bean.PersonBeanImpl;
import com.umessage.designpattern.proxy.handler.OtherInvocationHanlder;
import com.umessage.designpattern.proxy.handler.OwnerInvocationHanlder;

/**
 * 动态代理模式测试类。代理模式可以有效控制外界对被代理对象的访问，达到实现访问控制的目的。
 * 
 * @author licb
 * 
 */
public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PersonBean person = new PersonBeanImpl();
		// 所有者代理类可以设置自己除了rating之外的其它属性.
		PersonBean ownerProxy = getOwnerProxyBean(person);

		ownerProxy.setName("buddyli");
		System.out.println("Name is " + ownerProxy.getName());

		ownerProxy.setGender("Male");
		System.out.println("Gender is " + ownerProxy.getGender());

		try {
			ownerProxy.setHotOrNotRating(5);
		} catch (Exception e) {
			System.out.println("Can not set rating from owner proxy.");
		}
		System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

		System.out.println("=============");

		// 非所有者代理只可设置其它对象的rating属性,而不能设置其它对象的name, gender等属性.
		PersonBean otherProxy = getOtherProxyBean(person);
		try {
			otherProxy.setName("Hello Jeek!");
		} catch (Exception e) {
			System.out.println("Can not set properties other than rating from non owner proxy.");
		}
		System.out.println("Name is " + ownerProxy.getName());

		otherProxy.setHotOrNotRating(10);
		System.out.println("Rating is " + otherProxy.getHotOrNotRating());
	}

	static PersonBean getOwnerProxyBean(PersonBean person) {
		// System.out.println(PersonBean.class);//接口
		// System.out.println(person.getClass());// 实现类
		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new OwnerInvocationHanlder(person));
	}

	static PersonBean getOtherProxyBean(PersonBean person) {
		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new OtherInvocationHanlder(person));
	}
}
