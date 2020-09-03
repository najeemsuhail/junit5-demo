package com.nextsky.junitdemo;

import com.nextsky.junitdemo.area.CalculateArea;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunitDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitDemoApplication.class, args);
		CalculateArea calculateArea = new CalculateArea();
		System.out.println(calculateArea.rectangleArea(2, 5));
	}

}
