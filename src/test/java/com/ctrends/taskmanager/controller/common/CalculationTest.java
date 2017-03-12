package com.ctrends.taskmanager.controller.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculationTest {


	Calculation calResult = new Calculation();

	@Test
	public void testAdd() { 
		double result = calResult.add(5.50, 5.50);
		assertEquals(11.00, result, 0.3);				
	}
	
	@Test
	public void testAdd_NegativeNumber() {	
		double result = calResult.add(-5.50, -5.50);
		assertEquals(-11.00, result, 0.3);
	}
	
	@Test
	public void testAdd_WrongNumber() {
		double result = calResult.add(-5.5, 5);
		assertEquals(-0.5, result, 0.3);
	}
	
	@Test
	public void testAdd_DataType() {
		double result = calResult.add(5.5, 5);
		assertEquals(10.5, result, 0.3);
	}
	
	@Test
	public void testAdd_ValZero() {
		double result = calResult.add(0, 0);
		assertEquals(0, result, 0.3);
	}
	
	@Test
	public void testAdd_LargeNumber() {
		double result = calResult.add(55555555555.00, 22222222222.00);
		assertEquals(77777777777.00, result, 0.3);
	}
	
	/*@Test
	public void testAdd_StringValue() {
		Calculation calResult = new Calculation();
		double result = calResult.add("add", "add");
		assertEquals(100, result, 0.3);
	}*/


}
