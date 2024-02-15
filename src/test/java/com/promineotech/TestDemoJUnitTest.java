package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	//A parameterized test for the example method that tests to make sure method is running as expected
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
		}
		else{
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
		}
			
	}
	//Stream for addPositive Method
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(1, 1, 2, false),
				arguments(5, 15, 20, false)
				);
	}
	
	//Standard test to test positive number pairs
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		assertThat(testDemo.addPositive(7, 8)).isEqualTo(15);
		assertThat(testDemo.addPositive(107, 53)).isEqualTo(160);
		assertThat(testDemo.addPositive(24, 13)).isEqualTo(37);
	}
	
	//A parameterized test to test and make sure the method is running as expected
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForWordGreaterThanFive")
	void assertThatStringLengthIsGreaterThan5(String s, boolean expected) {
		assertThat(testDemo.wordGreaterThanFive(s)).isEqualTo(expected);
	}
	
	//Stream for testing the custom method
	static Stream<Arguments> argumentsForWordGreaterThanFive() {
		return Stream.of(
				arguments("Sauce", false),
				arguments("Pokemon", true),
				arguments("Yam", false)
				);
	}
	
	//Mocking the method in order to rest functionality.
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	

}
