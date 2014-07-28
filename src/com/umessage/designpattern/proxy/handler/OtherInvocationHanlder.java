package com.umessage.designpattern.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.umessage.designpattern.proxy.bean.PersonBean;

/**
 * 每个对象可以设置别人的好评度，但是不能设置除了好评度之外的其它人的属性。例如，一个对象不可以设置其它对象的名字、性别等，仅仅可以获取这些属性。
 * 
 * @author licb
 * 
 */
public class OtherInvocationHanlder implements InvocationHandler {
	PersonBean person;

	public OtherInvocationHanlder(PersonBean person) {
		super();
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(person, args);
			} else if (method.getName().equals("setHotOrNotRating")) {
				return method.invoke(person, args);
			} else if (method.getName().startsWith("set")) {
				throw new IllegalAccessException();
			}

		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

}
