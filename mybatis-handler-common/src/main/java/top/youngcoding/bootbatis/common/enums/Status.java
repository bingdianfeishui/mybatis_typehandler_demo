package top.youngcoding.bootbatis.common.enums;

import top.youngcoding.bootbatis.common.CodeEnum;

/**
 * Created by liy on 2018-4-9.
 */
public enum Status implements CodeEnum<String> {
    LOCKED("L"), ENABLE("E"), DISABLE("D");
    private String code;

    Status(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
