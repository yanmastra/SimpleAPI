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
