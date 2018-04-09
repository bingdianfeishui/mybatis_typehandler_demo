package top.youngcoding.bootbatis.typehandler.anno.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import top.youngcoding.bootbatis.common.CodeAndDescEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liy on 2018-4-9.
 */
@MappedTypes(CodeAndDescEnum.class)   // 使用注解时，该注解必须有，否则会构造中的type无法注入
public class CodeAndDescEnumHandler extends BaseTypeHandler<CodeAndDescEnum> {
    private Class<? extends CodeAndDescEnum> type;

    public CodeAndDescEnumHandler(Class<? extends CodeAndDescEnum> type) {
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CodeAndDescEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.getCode());
    }

    @Override
    public CodeAndDescEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return CodeAndDescEnum.getByCode(type, rs.getObject(columnName));
    }

    @Override
    public CodeAndDescEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return CodeAndDescEnum.getByCode(type, rs.getObject(columnIndex));
    }

    @Override
    public CodeAndDescEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return CodeAndDescEnum.getByCode(type, cs.getObject(columnIndex));
    }
}
