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
		LOGGER.info("+main()");
		
		//Execute the application
		run();
		
		//Ask user to Run the search application again ?
		askToContinue();
		
		System.exit(0);
	}
	
	//Execute the application
	private static void run()
	{
		LOGGER.info("+run()");
		//Print headings data from Map to allow user to choose what they want from the periodic table
		ElementAttributeHeading elementAttributeHeading = new ElementAttributeHeading();
		Map<Integer, String> elements = elementAttributeHeading.getPeriodicTableOfElementsColumnHeadingAttributesMap();
		elements.forEach((key, value) -> System.out.println(key + " : " + value));
		
		ReadingElementsFromFile readingElementsFromFile = new ReadingElementsFromFile();
		
		System.out.println("");
		getColumnOfElementsAttributes(readingElementsFromFile);
		
		System.out.println("");
		getRowOfElementData(readingElementsFromFile);
		
		System.out.println("");
	}
	
	//Get user input for which column of data they want to view
	private static void getColumnOfElementsAttributes(ReadingElementsFromFile readingElementsFromFile)
	{
		LOGGER.info("+getColumnOfElementsAttributes(ReadingElementsFromFile readingElementsFromFile)");
		System.out.println("");
		System.out.println("Enter the number of column: ");
		int userInputToChooseAttributeOfElement = SCANNER.nextInt();
		
		System.out.println("");
		LOGGER.info(" *** Periodic elements data *** ");
		PlaceElementsIntoDataStructures placeElementsIntoDataStructures = new PlaceElementsIntoDataStructures(readingElementsFromFile.readAllElementsFromFile());

		// Get name of elements and one column of data from user input choice and format by removing comma
		System.out.println("");
		List<String> listOfElementNames = placeElementsIntoDataStructures.putDataIntoList(2);
		List<String> listOfElementsAttributesTheUserChooses = placeElementsIntoDataStructures.putDataIntoList(userInputToChooseAttributeOfElement);
		
		//Add elements data to a map and then print out the data. Key: Element name and Value: User chooses
		System.out.println("");
		Map<String, String> mapOfListedData = placeElementsIntoDataStructures.putTwoListsIntoMap(listOfElementNames, listOfElementsAttributesTheUserChooses);
		mapOfListedData.forEach((key, value) -> {
			System.out.println("");
			LOGGER.info(" Element: " + key + " : Attribute value: " + value);
		});
		
		System.out.println("");
	}
	
	// Print element row with all it's attributes by searching for the elements symbol
	private static void getRowOfElementData(ReadingElementsFromFile readingElementsFromFile)
	{
		LOGGER.info("+getRowOfElementData(ReadingElementsFromFile readingElementsFromFile)");
		System.out.println("");
		System.out.println("Enter Symbol initials of element for row: ");
		String elementSymbol = SCANNER.next();
		
		System.out.println("");
		LOGGER.info(" *** Periodic elements data *** ");
		PlaceElementsIntoDataStructures placeElementsIntoDataStructures = new PlaceElementsIntoDataStructures(readingElementsFromFile.readOneRowOfElementDataFromFile(elementSymbol));

		// Get name of elements and one column of data from user input choice and no need to format by removing comma
		System.out.println("");
//	    placeElementsIntoDataStructuresTwo.getReadingElementsFromFileList().forEach(System.out::println);
		placeElementsIntoDataStructures.getReadingElementsFromFileList().forEach(myPojo -> LOGGER.info(" " + myPojo.toString() + " "));
		
		System.out.println("");
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
