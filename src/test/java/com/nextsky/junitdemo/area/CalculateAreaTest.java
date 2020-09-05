package com.nextsky.junitdemo.area;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
class CalculateAreaTest {
	
	private CalculateArea calculateArea;
	private TestInfo testInfo;
	private TestReporter testReporter;
	
	@Nested
	@DisplayName("Group specifc")
	class GroupingTest{
		@Test
		@DisplayName("Rectacle Area")
		
		void testRectangleArea() {
			System.out.println("Nested Rectacle");
			//CalculateArea calculateArea = new CalculateArea();
			  int area = calculateArea.rectangleArea(5, 6);		      
			  assertEquals(30, area, "Area of rectangle");		   
		}

		@Test
		@DisplayName("Circle Area")
		void testCircleArea() {		
			System.out.println("Nested Circle");
			//CalculateArea calculateArea = new CalculateArea();
			  double actual = calculateArea.circleArea(5);
			  double expected = Math.PI * 5;
			  assertEquals(expected, actual, "Area of circle");	   
		}
	}
	
	@BeforeAll
	static void beforeEveryone() {		
		System.out.println("Before All");
	}

	@AfterAll
	static void afterEveryone() {
		System.out.println("After All");
	}
	
	@BeforeEach
	void beforEachMethod(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		calculateArea = new CalculateArea();
		System.out.println("Before Each method");
	}
	
	@AfterEach
	void afterEachMethod() {
		System.out.println("After Each method");
	}
	//@Tag("hey")
	@Test
	@DisplayName("Rectacle Area")
	
	void testRectangleArea() {
		System.out.println("Rectacle");
		//CalculateArea calculateArea = new CalculateArea();
		  int area = calculateArea.rectangleArea(5, 6);		      
		  assertEquals(30, area, "Area of rectangle");		   
	}

	@Test
	@DisplayName("Circle Area")
	void testCircleArea() {		
		System.out.println("Circle");
		//CalculateArea calculateArea = new CalculateArea();
		  double actual = calculateArea.circleArea(5);
		  double expected = Math.PI * 5;
		  assertEquals(expected, actual, "Area of circle");	   
	}
	
	@Test
	void testAllMethds() {
		  double actual = calculateArea.circleArea(5);
		  double expected = Math.PI * 5;
		  int area = calculateArea.rectangleArea(5, 6);		 
		assertAll(
				() -> assertEquals(expected, actual, "Area of circle"),
				() -> assertEquals(30, area, "Area of rectangle")	 
				);
	}
	

	@RepeatedTest(value = 3,name = RepeatedTest.SHORT_DISPLAY_NAME)
	void repeateMe(RepetitionInfo repetitionInfo) {

		 testReporter.publishEntry(testInfo.getDisplayName() +" Running "+ testInfo.getTestMethod().get().getName());
		System.out.println("Repating.. " + repetitionInfo.getCurrentRepetition());
	}
}
