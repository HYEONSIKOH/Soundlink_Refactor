package com.dfbf.soundlink;

import com.dfbf.soundlink.global.config.FeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "org.dfbf.soundlink.global.feign", defaultConfiguration = FeignConfig.class)
@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
@EnableCaching
public class DefaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(DefaultApplication.class, args);
	}

}
