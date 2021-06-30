package io.github.yanmastra.simpleapi.services;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(TestConfig.class)
public class TestService {
    private final TestConfig testConfig;

    public TestService(TestConfig testConfig) {
        this.testConfig = testConfig;
    }

    public String getMessage(){
        return testConfig.getMessage();
    }
}
