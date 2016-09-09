package main.ie.murph.application;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import main.ie.murph.model.PlaceElementsIntoDataStructures;
import main.ie.murph.model.ReadingElementsFromFile;
import main.ie.murph.view.ElementAttributeHeading;

public class App {

	private static final Logger LOGGER = Logger.getLogger(App.class.getName());
	private static final Scanner SCANNER = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		//Print headings data from Map to allow user to choose what they want from the periodic table
		ElementAttributeHeading elementAttributeHeading = new ElementAttributeHeading();
		elementAttributeHeading.getPeriodicTableOfElementsColumnHeadingAttributes();
		
		//Get user input
		System.out.println("");
		LOGGER.info("Enter the number: ");
		int userInputToChooseAttributeOfElement = SCANNER.nextInt();
		
		System.out.println("");
		LOGGER.info(" *** Periodic elements data *** ");
		ReadingElementsFromFile readingElementsFromFile = new ReadingElementsFromFile();
		PlaceElementsIntoDataStructures placeElementsIntoDataStructures = new PlaceElementsIntoDataStructures(readingElementsFromFile);
		
		// Get name of elements and one column of data from user input choice
		List<String> listOfElementNames = placeElementsIntoDataStructures.putDataIntoList(2);
		List<String> listOfElementsAttributesTheUserChooses = placeElementsIntoDataStructures.putDataIntoList(userInputToChooseAttributeOfElement);
		
		//Add elements data to a map and then print out the data. Key: Element name and Value: User chooses
		Map<String, String> mapOfListedData = placeElementsIntoDataStructures.putTwoListsIntoMap(listOfElementNames, listOfElementsAttributesTheUserChooses);
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
