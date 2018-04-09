package top.youngcoding.bootbatis.common;

/**
 * 带一个Code参数Enum的父类接口
 * Created by liy on 2018-4-9.
 */
public interface CodeEnum<T> {
    T getCode();

    static CodeEnum getByCode(Class<? extends CodeEnum> clazz, Object code) {
        if (clazz.isEnum() && CodeEnum.class.isAssignableFrom(clazz)) {
            for (Object obj : clazz.getEnumConstants()) {
                CodeEnum en = (CodeEnum) obj;
                if (en != null && en.getCode().equals(code))
                    return en;
            }
        }
        return null;
    }
}
