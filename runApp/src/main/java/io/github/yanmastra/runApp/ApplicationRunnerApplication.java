package io.github.yanmastra.runApp;

import io.github.yanmastra.simpleapi.services.TestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "io.github.yanmastra.simpleapi")
@RestController
public class ApplicationRunnerApplication {

	private final TestConfig service;

	public ApplicationRunnerApplication(TestConfig service) {
		this.service = service;
	}


	@GetMapping("call_test_from_runner")
	String call(){
		return service.getMessage();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRunnerApplication.class, args);
	}

}
