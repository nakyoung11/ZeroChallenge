package com.nakihome.zerochallenge.user.model;

public class SnsUserVO extends UserVO {

	private int subscription_path;
	private String user_id;
	private String age;

	public int getSubscription_path() {
		return subscription_path;
	}

	public void setSubscription_path(int subscription_path) {
		this.subscription_path = subscription_path;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
