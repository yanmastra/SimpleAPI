/*
  Copyright 2021 I Wayan Mastra

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.
 */

package io.github.yanmastra.simpleapi.utils;

import org.springframework.lang.NonNull;

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
