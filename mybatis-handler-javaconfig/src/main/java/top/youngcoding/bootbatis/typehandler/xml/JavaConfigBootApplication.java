package top.youngcoding.bootbatis.typehandler.xml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import top.youngcoding.bootbatis.common.mapper.UserMapper;
import top.youngcoding.bootbatis.common.entity.User;
import top.youngcoding.bootbatis.common.enums.Gender;
import top.youngcoding.bootbatis.common.enums.PlayerGrade;
import top.youngcoding.bootbatis.common.enums.RegistryType;
import top.youngcoding.bootbatis.common.enums.Status;

import java.util.Date;

/**
 * Created by liy on 2018-4-9.
 */
@SpringBootApplication
@MapperScan({"top.youngcoding.bootbatis.common.mapper"})
public class JavaConfigBootApplication {
    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(JavaConfigBootApplication.class, args);
    }

    @Bean
    CommandLineRunner CRUD() {
        return args -> {
            System.out.println("=============C==================");
            User user = new User("jerry", Gender.FEMALE, RegistryType.PHONE, Status.DISABLE, PlayerGrade.BRONZE, new Date());
            System.out.println(userMapper.insert(user));
            System.out.println(user);

            // get id
            Integer id = user.getId();

            System.out.println("=============R==================");
            user = userMapper.selectById(id);
            System.out.println(user);

            System.out.println("=============U==================");
            user.setUsername("new jerry");
            user.setGender(Gender.MALE);
            user.setRegistryType(RegistryType.WEIXIN);
            user.setStatus(Status.ENABLE);
            user.setPlayerGrade(PlayerGrade.GOLD);
            System.out.println(userMapper.updateByExample(user));
            System.out.println(userMapper.selectById(user.getId()));

            System.out.println("=============D==================");
            System.out.println(userMapper.deleteById(id));
        };
    }
}
