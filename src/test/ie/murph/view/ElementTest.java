package test.ie.murph.view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElementTest {

	private int _valueOne;
	private int _valueTwo;
	private int _sum;
	
	@Before
	public void setUp() throws Exception {
		//super.setUp();
		
		this._valueOne = 2;
		this._valueTwo = 3;
		this._sum = this._valueOne + this._valueTwo;
	}

	@After
	public void tearDown() throws Exception {
//		super.tearDown();
		
		this._valueOne = 0;
		this._valueTwo = 0;
		this._sum = 0;
	}

	@Test
	public void testAdd() {
//		fail("Not yet implemented");
//		int sum = Calculation.add(value1, value2);
		
		int total = 5;
		assertEquals(this._sum, total);
		
	}
}
