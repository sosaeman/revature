package com.revature.basicsTest;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import com.revature.basics.MathOps;

public class MathTest {
private MathOps m;
	@Before
	public void setGo() {
		m = new MathOps();
	}
	@Test
	public void add() {
	
		int result = m.add(1,2);
		assertTrue(result == 3);
	};
	
	@Test
	public void sub() {
		
		int result1 = m.subtract(5,2);
		assertTrue(result1 == 2);
	};

}
