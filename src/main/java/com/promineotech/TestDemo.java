package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	//Simple method for testing
	public int addPositive(int a, int b) {

		if (a <= 0 && b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive");
		}
		return a + b;

	}
	
	//Method to check if a word is greater than 5 words and returns a boolean value
	public boolean wordGreaterThanFive(String s) {
		
		return s.length() > 5;
		
	}
	
	public int randomNumberSquared() {
		int ranInt = getRandomInt();
		
		return ranInt * ranInt;
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

}
