package top.youngcoding.bootbatis.common.entity;

import lombok.*;
import top.youngcoding.bootbatis.common.enums.Gender;
import top.youngcoding.bootbatis.common.enums.PlayerGrade;
import top.youngcoding.bootbatis.common.enums.RegistryType;
import top.youngcoding.bootbatis.common.enums.Status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实体类
 * Created by liy on 2018-4-9.
 */
@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class User {
    private Integer id;
    private String username;
    private Gender gender;
    private RegistryType registryType;
    private Status status;
    private PlayerGrade playerGrade;
    private Date registerTime;

    public User(String username, Gender gender, RegistryType registryType, Status status, PlayerGrade playerGrade, Date registerTime) {
        this.username = username;
        this.gender = gender;
        this.registryType = registryType;
        this.status = status;
        this.playerGrade = playerGrade;
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", registryType=" + registryType +
                ", status=" + status +
                ", playerGrade=" + playerGrade.getDesc() +
                ", registerTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(registerTime) +
                '}';
    }
}
