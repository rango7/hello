package com.evergrande.sonar.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 读取properties文件的工具类
 *
 * @author 莫小哆_ly 2012-3-30
 */
public class PropertyUtils {
    private static Properties p = new Properties();

    /**
     * 读取properties配置文件信息 
     */
    static {
        try {
            p.load(PropertyUtils.class.getClassLoader().getResourceAsStream("commons.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据key得到value的值
     */
    public static String getValue(String key) {
        return p.getProperty(key);
    }
}  