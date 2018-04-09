package top.youngcoding.bootbatis.common.enums;

import top.youngcoding.bootbatis.common.CodeAndDescEnum;

/**
 * Created by liy on 2018-4-9.
 */
public enum PlayerGrade implements CodeAndDescEnum<String, String> {
    IRON("1001", "玄铁"), BRONZE("1002", "青铜"), SILVER("1003", "白银"), GOLD("1004", "黄金");
    private String code;
    private String desc;

    PlayerGrade(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
