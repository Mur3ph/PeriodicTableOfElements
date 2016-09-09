package ie.murph.view;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ElementAttributeHeading {

	private static final Logger LOGGER = Logger.getLogger(ElementAttributeHeading.class.getName());
	
	//Print headings data from Map to allow user to choose what they want from the periodic table
	public void getPeriodicTableOfElementsColumnHeadingAttributes()
	{
		Map<Integer, String> elements = new HashMap<Integer, String>();
		elements.put(0, "Atomic number");
		elements.put(1, "Element name");
		elements.put(2, "Atomic mass in au or g/mol");
		elements.put(3, "CPK color in RRGGBB hex format");
		elements.put(4, "Electronic configuration");
		elements.put(5, "Electronegativity in Pauling");
		elements.put(6, "Atomic radius in pm");
		elements.put(7, "Ion radius in pm");
		elements.put(8, "Van der Waals radius in pm");
		elements.put(9, "IE-1 in kJ/mol");
		elements.put(10, "EA in kJ/mol");
		elements.put(11, "Oxidation states");
		elements.put(12, "Standard state");
		elements.put(13, "Bonding type");
		elements.put(14, "Melting point in K");
		elements.put(15, "Boiling point in K");
		elements.put(16, "Density in g/mL");
		elements.put(17, "Metal or nonmetal?");
		elements.put(18, "Year discovered");
		
		System.out.println(" ");
		LOGGER.info("*** Headings of data ***");
		System.out.println(" ");
		elements.forEach((key, value) -> System.out.println(key + " : " + value));
	}	
}
