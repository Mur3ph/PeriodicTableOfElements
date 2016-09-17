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
		//Execute the application
		run();
		
		//Ask user to Run the search application again ?
		askToContinue();
		
		//Get a list of list of data
		System.out.println("");
		
		System.exit(0);
	}
	
	private static void run()
	{
		//Print headings data from Map to allow user to choose what they want from the periodic table
		ElementAttributeHeading elementAttributeHeading = new ElementAttributeHeading();
		elementAttributeHeading.getPeriodicTableOfElementsColumnHeadingAttributes();
		
		//Get user input
		System.out.println("");
		LOGGER.info("Enter the number: ");
		int userInputToChooseAttributeOfElement = SCANNER.nextInt();
		
		// Print just one element with all it's attributes
		System.out.println("");
		System.out.println("Enter Symbol of element: ");
		String elementSymbol = SCANNER.next();
		
		System.out.println("");
		LOGGER.info(" *** Periodic elements data *** ");
		ReadingElementsFromFile readingElementsFromFile = new ReadingElementsFromFile();
		PlaceElementsIntoDataStructures placeElementsIntoDataStructuresOne = new PlaceElementsIntoDataStructures(readingElementsFromFile.readAllElementsFromFile());
		PlaceElementsIntoDataStructures placeElementsIntoDataStructuresTwo = new PlaceElementsIntoDataStructures(readingElementsFromFile.readOneRowOfElementDataFromFile(elementSymbol));

		// Get name of elements and one column of data from user input choice and format by removing comma
		System.out.println("");
		List<String> listOfElementNames = placeElementsIntoDataStructuresOne.putDataIntoList(2);
		List<String> listOfElementsAttributesTheUserChooses = placeElementsIntoDataStructuresOne.putDataIntoList(userInputToChooseAttributeOfElement);
		
		//Add elements data to a map and then print out the data. Key: Element name and Value: User chooses
		System.out.println("");
		Map<String, String> mapOfListedData = placeElementsIntoDataStructuresOne.putTwoListsIntoMap(listOfElementNames, listOfElementsAttributesTheUserChooses);
		mapOfListedData.forEach((key, value) -> {
			LOGGER.info(" Element: " + key + " : Attribute value: " + value);
		});
		
		// Get name of elements and one column of data from user input choice and no need to format by removing comma
		System.out.println("");
//		placeElementsIntoDataStructuresTwo.getReadingElementsFromFileList().forEach(System.out::println);
		placeElementsIntoDataStructuresTwo.getReadingElementsFromFileList().forEach(myPojo -> LOGGER.info(myPojo.toString()));
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
