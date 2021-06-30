package io.github.yanmastra.simpleapi.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.lang.NonNull;

import java.io.*;
import java.net.URLDecoder;
import java.util.Properties;

public class ConfigProperties {
    private static final Log logger = LogFactory.getLog(ConfigProperties.class.getSimpleName());
    private static Properties properties;
    private static File file;
    private static ConfigOptions options;

    public static String getProperty(String key) {
        return getProperty(key, "");
    }

    public static String getProperty(String key, String mDefault) {
        loadPropertiesIfNull();
        if (properties.containsKey(key))
            return properties.getProperty(key, mDefault);
        else {
            putProperty(key, mDefault);
            return getProperty(key, mDefault);
        }
    }

    public static void putProperty(String key, String value) {
        properties.put(key, value);
        try {
            properties.store(new FileOutputStream(file), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reset(){
        properties = null;
        loadPropertiesIfNull();
    }

    public static void init(@NonNull ConfigOptions options){
        if (ConfigProperties.options == null){
            ConfigProperties.options = options;
        }
        loadPropertiesIfNull();
    }

    private static void loadPropertiesIfNull() {
        InputStream inputStream;
        OutputStream os = null;
        if (properties == null) {
            if (options == null){
                options = new ConfigOptions.Builder().build();
            }

            try {
                properties = new Properties();
                String path = options.getConfigDir();
                path = URLDecoder.decode(path, "utf-8");
                file = new File(path + "/"+options.getPropertiesName()+".properties");
                logger.error("ConfigProperties:"+file.getPath());
                if (file.exists()) {
                    inputStream = new FileInputStream(file);
                    properties.load(inputStream);
                } else {
                    properties.setProperty(Constant.DB_USERNAME, "root");
                    properties.setProperty(Constant.DB_PASSWORD, "");

                    os = new FileOutputStream(file);
                    properties.store(os, null);
                }

            } catch (IOException e) {
                logger.error(e);
            } finally {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        logger.error(e);
                    }
                }
            }
        }
    }
}
