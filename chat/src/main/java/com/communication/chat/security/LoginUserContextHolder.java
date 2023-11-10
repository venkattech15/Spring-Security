package com.communication.chat.security;

public class LoginUserContextHolder {

	private LoginUserContextHolder() {
	}

	private static final ThreadLocal<String> appUserId = new ThreadLocal<String>();
	private static final ThreadLocal<String> appUserName = new ThreadLocal<String>();

	public static void setLoggedInUserID(String loggedInUser) {
		if (loggedInUser == null) {
			throw new NullPointerException();
		}
		appUserId.set(loggedInUser);
	}

	public static void clearLoggedInUserIdHolder() {
		appUserId.remove();
	}

	public static String getAppUserID() {
		return appUserId.get();
	}

	public static void setLoggedInUserName(String loggedInUser) {
		if (loggedInUser == null) {
			throw new NullPointerException();
		}
		appUserName.set(loggedInUser);
	}

	public static void clearLoggedInUserNameHolder() {
		appUserName.remove();
	}

	public static String getAppUserName() {
		return appUserName.get();
	}

}
