package com.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalcTest {
	
		Calculator calc=new Calculator();
		@Test
		public void testAdd() {
			assertEquals(11,calc.add(5, 6));
		}
		@Test
		public void testsub() {
			assertEquals(2,calc.sub(8, 6));
		}
		@Test
		public void testmul() {
			assertEquals(40,calc.mul(8, 5));
		}
		@Test 
		public void testdiv() {
			assertEquals(2,calc.div(8, 4)); 
		} 
		  
	}  

