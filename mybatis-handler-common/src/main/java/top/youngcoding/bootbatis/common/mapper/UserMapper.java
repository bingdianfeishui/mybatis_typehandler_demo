package top.youngcoding.bootbatis.common.mapper;

import org.apache.ibatis.annotations.*;
import top.youngcoding.bootbatis.common.entity.User;

import java.io.Serializable;

/**
 * Created by liy on 2018/4/9.
 */
@Mapper
public interface UserMapper {
    @Insert("insert into m_user values(#{id}, #{username}, #{gender}, #{registryType}, #{status}, #{playerGrade}, #{registerTime})")
    int insert(User user);

    @Select("select * from m_user where id=#{id}")
    User selectById(Serializable id);

    @Update("update m_user set username=#{username}, gender=#{gender}, registry_type=#{registryType}, status=#{status}, player_grade=#{playerGrade}, register_time=#{registerTime} where id=#{id}")
    int updateByExample(User user);

    @Delete("delete from m_user where id=#{id}")
    int deleteById(Serializable id);
}
