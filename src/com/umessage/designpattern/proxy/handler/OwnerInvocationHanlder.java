package com.umessage.designpattern.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.umessage.designpattern.proxy.bean.PersonBean;

/**
 * 每个对象可以设置自己的除了rating之外的其它属性。
 * 
 * @author licb
 * 
 */
public class OwnerInvocationHanlder implements InvocationHandler {
	PersonBean person;

	public OwnerInvocationHanlder(PersonBean person) {
		super();
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(person, args);
			} else if (method.getName().equals("setHotOrNotRating")) {
				throw new IllegalAccessException();
			} else if (method.getName().startsWith("set")) {
				method.invoke(person, args);
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

}
