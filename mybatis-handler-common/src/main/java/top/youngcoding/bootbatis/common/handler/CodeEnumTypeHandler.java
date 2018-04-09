package top.youngcoding.bootbatis.common.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import top.youngcoding.bootbatis.common.CodeEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liy on 2018-4-9.
 */
public class CodeEnumTypeHandler extends BaseTypeHandler<CodeEnum<?>> {
    private Class<? extends CodeEnum> type;
    public CodeEnumTypeHandler(Class<? extends CodeEnum<?>> type) {
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CodeEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.getCode());
    }

    @Override
    public CodeEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return CodeEnum.getByCode(type, rs.getObject(columnName));
    }

    @Override
    public CodeEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return CodeEnum.getByCode(type, rs.getObject(columnIndex));
    }

    @Override
    public CodeEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return CodeEnum.getByCode(type, cs.getObject(columnIndex));
    }
}
