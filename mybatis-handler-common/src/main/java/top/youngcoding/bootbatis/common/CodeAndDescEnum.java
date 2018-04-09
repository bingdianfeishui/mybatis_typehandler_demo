package top.youngcoding.bootbatis.common;

/**
 * 带Code和Desc描述两个参数的枚举父类接口
 * Created by liy on 2018-4-9.
 */
public interface CodeAndDescEnum<K, V> {
    K getCode();

    V getDesc();

    static CodeAndDescEnum<?, ?> getByCode(Class<? extends CodeAndDescEnum> type, Object code) {
        if (type.isEnum() && CodeAndDescEnum.class.isAssignableFrom(type)) {
            for (Object obj : type.getEnumConstants()
                    ) {
                CodeAndDescEnum cade = (CodeAndDescEnum) obj;
                if (cade != null && cade.getCode().equals(code))
                    return cade;
            }
        }
        return null;
    }
}
