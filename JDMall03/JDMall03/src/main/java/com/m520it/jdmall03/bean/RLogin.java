package com.m520it.jdmall03.bean;

public class RLogin {

	private long id;
	private String userName;
	private String userIcon;
	private int waitPayCount;
	private int waitReceiveCount;
	private int userLevel;// 1注册会员2铜牌会员3银牌会员4金牌会员5钻石会员

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public int getWaitPayCount() {
		return waitPayCount;
	}

	public void setWaitPayCount(int waitPayCount) {
		this.waitPayCount = waitPayCount;
	}

	public int getWaitReceiveCount() {
		return waitReceiveCount;
	}

	public void setWaitReceiveCount(int waitReceiveCount) {
		this.waitReceiveCount = waitReceiveCount;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

}
