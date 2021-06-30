package io.github.yanmastra.simpleapi.utils;

import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;

public class ConfigOptions {
    private String configDir = System.getProperty("user.dir");
    private String logDir = System.getProperty("user.dir");
    private String propertiesName = "application";

    private ConfigOptions(){}

    public String getConfigDir() {
        return configDir;
    }

    public String getLogDir() {
        return logDir;
    }

    public String getPropertiesName() {
        return propertiesName;
    }

    public static class Builder{
        private final ConfigOptions options;
        public Builder(){
            options = new ConfigOptions();
        }

        public Builder setConfigDir(@NonNull String dir){
            options.configDir = dir;
            return this;
        }

        public Builder setLogDir(@NonNull String logDir){
            options.logDir = logDir;
            return this;
        }

        public Builder setPropertiesName(@NonNull String fileName){
            fileName = fileName.trim().replace(" ", "_");
            if (fileName.endsWith(".properties")) fileName = fileName.substring(0, fileName.length() - 11);
            options.propertiesName = fileName;
            return this;
        }

        public ConfigOptions build(){
            return options;
        }
    }
}
