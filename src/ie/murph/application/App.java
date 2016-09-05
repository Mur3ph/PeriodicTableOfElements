package ie.murph.application;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import ie.murph.model.ReadingElements;
import ie.murph.view.ElementData;

public class App {

	private static final Logger LOGGER = Logger.getLogger(App.class.getName());
	private static final Scanner M_SCANNER = new Scanner(System.in);
	public static void main(String[] args)
	{
		//Print headings data from Map to allow user to choose what they want from the periodic table
		ElementData viewElementData = new ElementData();
		viewElementData.getPeriodicTableDataHeadings();
		
		//Get user input
		System.out.println("");
		LOGGER.info("Enter the number: ");
		int number = M_SCANNER.nextInt();
		
		System.out.println("");
		LOGGER.info(" *** Periodic elements data *** ");
		ReadingElements read = new ReadingElements();
		
		// Get name of elements and one column of data from user input choice
		List<String> listOfElementNames = read.readIndividualElementsFromFile(2);
		List<String> list1 = read.readIndividualElementsFromFile(number);
		//list1.forEach(System.out::println);
		
		Map<String, String> mapOfListedData = viewElementData.listsToMap(listOfElementNames, list1);
		mapOfListedData.forEach((key, value) -> {
			LOGGER.info(" Element: " + key + " : Attribute value: " + value);
		});
		
		//Run the search application again ?
		askToContinue();
		
		//Get a list of list of data
		System.out.println("");
//		List<List<String>> list2 = read.readAllElementsFromFile();
//		list2.forEach(System.out::println);
		
		System.exit(0);
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
			System.out.println("");
			LOGGER.info("Good bye!");
			System.exit(0);
		}
		else
			System.out.println("");
			LOGGER.info("Do you want to run it again: (y/n)");
			askToContinue();
			
	}
	
}
