package main.ie.murph.model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadingElementsFromFile {

	private static final Logger LOGGER = Logger.getLogger(ReadingElementsFromFile.class.getName());
	private static final String FILENAME = "File/periodic-table-of-elements.csv"; 
	
	public ReadingElementsFromFile(){}
	
	public List<String> readAllElementsFromFile()
	{
		LOGGER.info("+readAllElementsFromFile()");
		try (Stream<String> stream = Files.lines(Paths.get(FILENAME),Charset.defaultCharset())) 
		{
			return stream
					.collect(Collectors.toList());
		} catch (IOException ex) 
		{
	        System.out.println("");
	        LOGGER.warning("Error: " + ex.getMessage() + " +readAllElementsFromFile()");
		} 
		return null;
	}
	
	public List<String> readOneRowOfElementDataFromFile(String elementsSymbol)
	{
		LOGGER.info("+readOneRowOfElementDataFromFile(String elementsSymbol)");
//		int sizeOfSymbol = elementsSymbol.length()+1;
		try (Stream<String> stream = Files.lines(Paths.get(FILENAME),Charset.defaultCharset())) 
		{
//			If I return the first symbol found in certain situations I will never be able to access some Elements (e.g. I - Iodine)
//			LOGGER.info("*** " + stream.filter(line -> line.substring(line.indexOf(",")+1, line.indexOf(",")+5).trim().contains(elementsSymbol)).findFirst().get());
			return stream
					.filter(line -> line.substring(line.indexOf(",")+1, line.indexOf(",")+5).contains(elementsSymbol))
					.collect(Collectors.toList());
		} 
		catch (IOException ex) 
		{
	        System.out.println("");
	        LOGGER.warning("Error: " + ex.getMessage() + " +readAllElementsFromFile()");
		}
		return new ArrayList<String>(); 
	}

	
	
	
}
