package org.jypj.dev.utils;


import org.jypj.dev.base.BaseEnum;

/**
 * @author ChenYu
 * @create 2017-12-1 18:22:42
 */
public class EnumUtil {

    public static <T extends BaseEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
