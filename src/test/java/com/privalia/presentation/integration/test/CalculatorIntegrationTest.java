package com.privalia.presentation.integration.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.privalia.presentation.Calculator;


class CalculatorIntegrationTest {
	
	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		assertTrue(calculator.add(2, 3) == 5);
	}
	
	@Test
	public void testSubstract() {
		Calculator calculator = new Calculator();
		assertTrue(calculator.substract(2, 2) == 0);
	}

	@Test
	public void testMultiply() {
		Calculator calculator = new Calculator();
		assertTrue(calculator.multiply(2, 3) == 6);
	}
	
	@Test
	public void testDivide() {
		Calculator calculator = new Calculator();
//		Calculator calculator = new Calculator();
		assertTrue(calculator.divide(6, 2) == 3);
	}
	
}
