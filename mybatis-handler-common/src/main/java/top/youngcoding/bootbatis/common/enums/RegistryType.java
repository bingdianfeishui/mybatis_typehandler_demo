package top.youngcoding.bootbatis.common.enums;

import top.youngcoding.bootbatis.common.CodeEnum;

/**
 * 注册类型Enum，带单个int参数的enum
 * Created by liy on 2018-4-9.
 */
public enum RegistryType implements CodeEnum<Integer> {
    QQ(101), WEIBO(102),WEIXIN(103),PHONE(104);

    private final Integer code;

    RegistryType(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }
}
