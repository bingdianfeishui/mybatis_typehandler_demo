package top.youngcoding.bootbatis.typehandler.xml;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.youngcoding.bootbatis.common.CodeAndDescEnum;
import top.youngcoding.bootbatis.common.CodeEnum;
import top.youngcoding.bootbatis.common.handler.CodeAndDescEnumHandler;
import top.youngcoding.bootbatis.common.handler.CodeEnumTypeHandler;
import top.youngcoding.bootbatis.common.handler.DateToLongTypeHandler;

import javax.sql.DataSource;
import java.util.Date;

/**
 * Created by liy on 2018-4-9.
 */
@Configuration
public class MybatisConfig {
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.driver-class-name}")
    String driverClassName;

    @Bean(name = "dataSource")
    DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {

        try {
            SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
            factory.setDataSource(dataSource);
            SqlSessionFactory sqlSessionFactory = factory.getObject();

            // 允许驼峰转换
            sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);

            // 注册类型转换器
            TypeHandlerRegistry registry = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();
            registry.register(CodeEnum.class, CodeEnumTypeHandler.class);
            registry.register(CodeAndDescEnum.class, CodeAndDescEnumHandler.class);
            registry.register(Date.class, DateToLongTypeHandler.class);
            registry.setDefaultEnumTypeHandler(EnumOrdinalTypeHandler.class);

            return sqlSessionFactory;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
