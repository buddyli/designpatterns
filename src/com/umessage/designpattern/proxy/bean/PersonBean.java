package com.umessage.designpattern.proxy.bean;

public interface PersonBean {
	String getName();

	String getGender();

	String getInterests();

	// 受欢迎度
	int getHotOrNotRating();

	void setName(String name);

	void setGender(String gender);

	void setInterests(String interests);

	void setHotOrNotRating(int rating);
}
