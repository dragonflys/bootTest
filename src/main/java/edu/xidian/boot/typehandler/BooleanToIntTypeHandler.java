package edu.xidian.boot.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 
 * 将java Boolean类型存到数据库时转换为数字类型
 */
public class BooleanToIntTypeHandler extends BaseTypeHandler<Boolean> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType)
			throws SQLException {
		if (parameter) {
			ps.setInt(i, 1);
		} else {
			ps.setInt(i, 2);
		}

	}

	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int i = rs.getInt(columnName);
		if (rs.wasNull()) {
			return null;
		} else if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int i = rs.getInt(columnIndex);
		if (rs.wasNull()) {
			return null;
		} else if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int i = cs.getInt(columnIndex);
		if (cs.wasNull()) {
			return null;
		} else if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

}
