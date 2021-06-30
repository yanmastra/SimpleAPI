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

package io.github.yanmastra.simpleapi.securities;

import io.github.yanmastra.simpleapi.utils.ConfigProperties;
import io.github.yanmastra.simpleapi.utils.Constant;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConfigProvider {
    @Bean
    DataSource provideDataSource(){
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        String dbUrl = "jdbc:mysql://" + ConfigProperties.getProperty(Constant.DB_HOST, "localhost:3306")
                + "/" + ConfigProperties.getProperty(Constant.DB_NAME, "db_simple_api")
                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone="+ConfigProperties.getProperty(Constant.KEY_TIMEZONE, "Asia/Makassar");
//            System.err.println(dbUrl);
        dataSourceBuilder.url(dbUrl)
                .username(ConfigProperties.getProperty(Constant.DB_USERNAME, "root"))
                .password(ConfigProperties.getProperty(Constant.DB_PASSWORD, ""));
        return dataSourceBuilder.build();
    }
}
