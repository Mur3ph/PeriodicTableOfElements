package test.ie.murph.view;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import main.ie.murph.view.ElementAttributeHeading;

public class ElementAttributeHeadingTest {

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
	
	@Test
	public void getPeriodicTableOfElementsColumnHeadingAttributes()
	{
		ElementAttributeHeading elementAttributeHeading = new ElementAttributeHeading();
		Map<Integer, String> elements = elementAttributeHeading.getPeriodicTableOfElementsColumnHeadingAttributesMap();
		
		Map<Integer, String> expectedElements = new HashMap<Integer, String>();
		expectedElements.put(0, "Atomic number");
		expectedElements.put(1, "Element name");
		expectedElements.put(2, "Atomic mass in au or g/mol");
		expectedElements.put(3, "CPK color in RRGGBB hex format");
		expectedElements.put(4, "Electronic configuration");
		expectedElements.put(5, "Electronegativity in Pauling");
		expectedElements.put(6, "Atomic radius in pm");
		expectedElements.put(7, "Ion radius in pm");
		expectedElements.put(8, "Van der Waals radius in pm");
		expectedElements.put(9, "IE-1 in kJ/mol");
		expectedElements.put(10, "EA in kJ/mol");
		expectedElements.put(11, "Oxidation states");
		expectedElements.put(12, "Standard state");
		expectedElements.put(13, "Bonding type");
		expectedElements.put(14, "Melting point in K");
		expectedElements.put(15, "Boiling point in K");
		expectedElements.put(16, "Density in g/mL");
		expectedElements.put(17, "Metal or nonmetal?");
		expectedElements.put(18, "Year discovered");
		
		// 1). Test equal, ignore order
		assertThat(elements, is(expectedElements));
		
		// 2). Test size
		assertThat(elements.size(), is(19));
		
		// 3). Test map entry, best! Might need to add an override equals method to class
		assertTrue(expectedElements.equals(elements));
		
		// 4). Doesn't contain certain keys for elements
		assertEquals(null, elements.get(-1));
		assertEquals(null, elements.get(19));
		
		// 5). Contains certain keys for elements
		assertEquals(elements.get(18), expectedElements.get(18));
		
		// 5). Test remove
		elements.remove(18);
		assertEquals(null, elements.get(18));
		
	}	
}
