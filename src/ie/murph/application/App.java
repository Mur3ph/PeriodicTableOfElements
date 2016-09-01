package ie.murph.application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import ie.murph.model.ReadingElements;

public class App {

	private static final Logger LOGGER = Logger.getLogger(App.class.getName());
	private static final Scanner M_SCANNER = new Scanner(System.in);
	public static void main(String[] args)
	{
		//Print headings data from Map to allow user to choose what they want from the periodic table
		getPeriodicTableDataHeadings();
		
		//Get user input
		System.out.println("Enter the number: ");
		int number = M_SCANNER.nextInt();
		
		System.out.println("");
		System.out.println(" *** Periodic elements data *** ");
		ReadingElements read = new ReadingElements();
		
		// Get name of elements and one column of data from user input choice
		List<String> listOfElementNames = read.readIndividualElementsFromFile(2);
		List<String> list1 = read.readIndividualElementsFromFile(number);
		//list1.forEach(System.out::println);
		
		Map<String, String> mapOfListedData = listsToMap(listOfElementNames, list1);
		mapOfListedData.forEach((key, value) -> {
		    System.out.println("Element: " + key + " : Attribute value: " + value);
		});
		
		//Run the search application again ?
		askToContinue();
		
		//Get a list of list of data
		System.out.println("");
//		List<List<String>> list2 = read.readAllElementsFromFile();
//		list2.forEach(System.out::println);
	}
	
	// Method to ask the user if they want to try again.
	private static void askToContinue()
	{
		//System.out.println("Do you want to run it again: (y/n)");
		String s_continue = M_SCANNER.nextLine();
		if(s_continue.equalsIgnoreCase("y") || s_continue.equalsIgnoreCase("yes"))
		{
			// Reseting main thread and Starting again..
			main(new String[0]);
		}
		else if (s_continue.equalsIgnoreCase("n") || s_continue.equalsIgnoreCase("no"))
		{
			System.out.println("Good bye!");
			System.exit(0);
		}
		else
			System.out.println("Do you want to run it again: (y/n)");
			askToContinue();
			
	}
	
	//Place data from two lists into a single map, one list for keys and the other for corresponding values
	private static Map<String, String> listsToMap(List<String> keys, List<String> values) {
	    // check preconditions - sizes
	    Map<String, String> map = new HashMap<>();
	    for ( int i = 0; i < keys.size(); i++) {
	        map.put(keys.get(i), values.get(i));
	    }
		return map;
	}
	
	//Print headings data from Map to allow user to choose what they want from the periodic table
	private static void getPeriodicTableDataHeadings()
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
		
		LOGGER.info("*** Headings of data ***");
		System.out.println(" *** Headings of data *** ");
		elements.forEach((key, value) -> System.out.println(key + " : " + value));
	}
	
}
