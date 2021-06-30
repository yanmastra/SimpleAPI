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
