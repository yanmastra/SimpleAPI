package io.github.yanmastra.simpleapi;

import io.github.yanmastra.simpleapi.services.TestConfig;
import io.github.yanmastra.simpleapi.utils.ConfigProperties;
import io.github.yanmastra.simpleapi.utils.Constant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest("service.message=Hello")
class SimpleApiApplicationTests {

	@Autowired private TestConfig testConfig;

	@Test
	void contextLoads() {
		assertThat(testConfig.getMessage()).isNotNull();
	}

	@SpringBootApplication
	public static class TestConfiguration{
		public static void main(String[] args) {
			SpringApplication app = new SpringApplication(TestConfiguration.class);
			Map<String, Object> props = new HashMap<>();
			props.put(Constant.SERVER_PORT, ConfigProperties.getProperty(Constant.SERVER_PORT, "8081"));
			app.setDefaultProperties(props);
			app.run(args);
		}
	}

}
