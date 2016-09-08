package ie.murph.application;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import ie.murph.model.PlaceElementsIntoDataStructures;
import ie.murph.model.ReadingElementsFromFile;
import ie.murph.view.ElementData;

public class App {

	private static final Logger LOGGER = Logger.getLogger(App.class.getName());
	private static final Scanner SCANNER = new Scanner(System.in);
	public static void main(String[] args)
	{
		//Print headings data from Map to allow user to choose what they want from the periodic table
		ElementData viewElementData = new ElementData();
		viewElementData.getPeriodicTableDataHeadings();
		
		//Get user input
		System.out.println("");
		LOGGER.info("Enter the number: ");
		int userInputForElementsColumnNumberChoice = SCANNER.nextInt();
		
		System.out.println("");
		LOGGER.info(" *** Periodic elements data *** ");
		PlaceElementsIntoDataStructures placeElementsIntoDataStructures = new PlaceElementsIntoDataStructures();
		ReadingElementsFromFile readingElementsFromFileClass = new ReadingElementsFromFile(placeElementsIntoDataStructures);
		
		// Get name of elements and one column of data from user input choice
		List<String> listOfElementNames = readingElementsFromFileClass.readIndividualElementsFromFile(2);
		List<String> listOfElementsAttributesTheUserChooses = readingElementsFromFileClass.readIndividualElementsFromFile(userInputForElementsColumnNumberChoice);
		
		//Add elements data to a map and then print out the data. Key: Element name and Value: User chooses
		Map<String, String> mapOfListedData = viewElementData.listsToMap(listOfElementNames, listOfElementsAttributesTheUserChooses);
		mapOfListedData.forEach((key, value) -> {
			LOGGER.info(" Element: " + key + " : Attribute value: " + value);
		});
		
		//Ask user to Run the search application again ?
		askToContinue();
		
		//Get a list of list of data
		System.out.println("");
		
		System.exit(0);
	}
	
	// Method to ask the user if they want to try the application again.
	private static void askToContinue()
	{
		//System.out.println("Do you want to run it again: (y/n)");
		String s_continue = SCANNER.nextLine();
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
