package io.github.yanmastra.simpleapi.services;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("service")
public class TestConfig {

    private String message;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
