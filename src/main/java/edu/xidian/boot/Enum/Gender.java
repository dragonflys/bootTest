package edu.xidian.boot.Enum;

import edu.xidian.boot.EnumUtils.BaseEnum;

/**
 * 性别类型
 *
 */
public enum Gender implements BaseEnum {
	MAN(2), WOMAN(3);
	private int code;

	private Gender(int code) {
		this.code = code;
	}

	@Override
	public int getCode() {
		return code;
	}

}
