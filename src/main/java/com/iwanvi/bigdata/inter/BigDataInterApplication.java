package com.iwanvi.bigdata.inter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.iwanvi.bigdata.inter"})
@EnableSwagger2
@ServletComponentScan
public class BigDataInterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigDataInterApplication.class, args);
		System.out.println("启动成功****************");
	}

}
