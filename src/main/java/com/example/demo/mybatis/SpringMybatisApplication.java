/**
 * 
 */
package com.example.demo.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yungby
 *
 */
@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.mybatis.mapper")
public class SpringMybatisApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringApplication.class, args);
	}

}
