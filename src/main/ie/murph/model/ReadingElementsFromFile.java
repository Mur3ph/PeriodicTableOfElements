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
		List<String> list = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(FILENAME),Charset.defaultCharset())) 
		{
			return stream
					.filter(line -> line.contains(elementsSymbol))
					.collect(Collectors.toList());
		} catch (IOException ex) 
		{
	        System.out.println("");
	        LOGGER.warning("Error: " + ex.getMessage() + " +readAllElementsFromFile()");
		}
		return list; 
	}
	
}
