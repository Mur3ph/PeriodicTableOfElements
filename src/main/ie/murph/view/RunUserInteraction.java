package main.ie.murph.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import main.ie.murph.application.App;
import main.ie.murph.model.PlaceElementsIntoDataStructures;
import main.ie.murph.model.ReadingElementsFromFile;

public class RunUserInteraction 
{
	private static final Logger LOGGER = Logger.getLogger(App.class.getName());
	private static final Scanner SCANNER = new Scanner(System.in);
	
	//Execute the application
	public void runUserInteraction()
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
	public void getColumnOfElementsAttributes(ReadingElementsFromFile readingElementsFromFile)
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
	public void getRowOfElementData(ReadingElementsFromFile readingElementsFromFile)
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
}
