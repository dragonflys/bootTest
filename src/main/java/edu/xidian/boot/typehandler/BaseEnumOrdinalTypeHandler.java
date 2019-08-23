package edu.xidian.boot.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import edu.xidian.boot.Enum.BaseEnum;
import edu.xidian.boot.Enum.Marital;

@MappedTypes(value = { Marital.class })
public class BaseEnumOrdinalTypeHandler<E extends Enum<?> & BaseEnum> extends BaseTypeHandler<BaseEnum> {
    private Class<E> clazz;
    private final E[] enums;

    public BaseEnumOrdinalTypeHandler(Class<E> enumType) {
        if (enumType == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.clazz = enumType;
        this.enums = enumType.getEnumConstants();
        if (this.enums == null) {
            throw new IllegalArgumentException(enumType.getSimpleName() + " does not represent an enum type.");
        }
    }

    // set是完成java类型 -> 数据库类型转换
    // ps：PreparedStatement对象
    // i：PreparedStatement对象参数的位置
    // parameter:java类型
    // jdbcType:jdbc操作数据库的类型
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BaseEnum parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    /**
     * get是从数据库->java
     */
    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            for (E e : enums) {
                if (e.getCode() == i) {
                    return e;
                }
            }
        }
        return null;
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            for (E e : enums) {
                if (e.getCode() == i) {
                    return e;
                }
            }
        }
        return null;
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            for (E e : enums) {
                if (e.getCode() == i) {
                    return e;
                }
            }
        }
        return null;
    }
}
