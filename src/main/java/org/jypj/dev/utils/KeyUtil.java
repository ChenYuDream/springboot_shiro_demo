package org.jypj.dev.utils;

import java.util.Random;

/**
 * @author ChenYu
 */
public class KeyUtil {

    public static void main(String[] args) {
        System.out.println(genUniqueKey().length());
    }

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * 长度19位
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
