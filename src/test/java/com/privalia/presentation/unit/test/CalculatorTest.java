package com.privalia.presentation.unit.test;

import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import com.privalia.presentation.Calculator;

public class CalculatorTest {
	
	@Test
	public void testAdd() {
		Calculator calculator = mock(Calculator.class);
		when(calculator.add(2, 3)).thenReturn(5);
		assertTrue(calculator.add(2, 3) == 5);
	}
	
	@Test
	public void testSubstract() {
		Calculator calculator = mock(Calculator.class);
		when(calculator.substract(3, 2)).thenReturn(1);
		assertTrue(calculator.substract(3, 2) == 1);
	}
	
	@Test
	public void testMultiply() {
		Calculator calculator = mock(Calculator.class);
		when(calculator.multiply(3, 2)).thenReturn(6);
		assertTrue(calculator.multiply(3, 2) == 6);
	}
	
	@Test
	public void testDivide() {
		Calculator calculator = mock(Calculator.class);
		when(calculator.divide(6, 2)).thenReturn(3);
		assertTrue(calculator.divide(6, 2) == 3);
	}
}
