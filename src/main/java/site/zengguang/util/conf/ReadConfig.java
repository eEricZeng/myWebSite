package site.zengguang.util.conf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件信息.
 * 
 * @author zengguang
 */
public class ReadConfig {
    
    private static Properties properties;
    private static String configFile = "config/mywebsite.properties";
    
    /** 是否加载过配置文件*/
    private static boolean hasLoad = false;
    
    /**
     * 加载properties文件.
     * 
     * @param location properties文件路径
     */
    private static void loadProperties(String location) {
        InputStream inputStream = null;
        try {
            properties = new Properties();
            inputStream = ReadConfig.class.getClassLoader().getResourceAsStream(location);
            if (inputStream != null) {
                properties.load(inputStream);
                hasLoad = true;
            } else {
                throw new FileNotFoundException(location);
            }
        } catch (IOException e) {
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    
    /**
     * 根据key获取配置文件中的值.
     * 
     * @param key
     * @return
     */
    public static String getString(String key) {
        if (!hasLoad) {
            loadProperties(configFile);
        }
        return properties.getProperty(key);
    }
    
}
