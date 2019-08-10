package edu.xidian.boot.Enum;

import edu.xidian.boot.EnumUtils.BaseEnum;

public enum StuStatus implements BaseEnum {
	ONLINE(200), LOCKED(300), LOGOUT(400);

	private int code;

	private StuStatus(int code) {
		this.code = code;
	}

	@Override
	public int getCode() {
		return code;
	}

}
