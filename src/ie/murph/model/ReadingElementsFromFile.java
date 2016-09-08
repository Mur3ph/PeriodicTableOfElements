package ie.murph.model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ReadingElementsFromFile {

	private static final Logger LOGGER = Logger.getLogger(ReadingElementsFromFile.class.getName());
	private PlaceElementsIntoDataStructures m_placeElementsIntoDataStructures; 
	
	public ReadingElementsFromFile(PlaceElementsIntoDataStructures placeElementsIntoDataStructures)
	{
		this.m_placeElementsIntoDataStructures = placeElementsIntoDataStructures;
	}
	
	public List<List<String>> readAllElementsFromFile()
	{
		try (Stream<String> stream = Files.lines(Paths.get("File/periodic-table-of-elements.csv"),Charset.defaultCharset())) 
		{
            //stream.forEach(System.out::println);
			return m_placeElementsIntoDataStructures.putDataIntoListOfLists(stream);
		} catch (IOException ex) 
		{
	        System.out.println("");
	        LOGGER.warning("Error: " + ex.getMessage() + " +readAllElementsFromFile()");
		} 
		return null;
	}
	
	public List<String> readIndividualElementsFromFile(int number)
	{
		try (Stream<String> stream = Files.lines(Paths.get("File/periodic-table-of-elements.csv"),Charset.defaultCharset())) 
		{
            //stream.forEach(System.out::println);
			return m_placeElementsIntoDataStructures.putDataIntoList(stream, number);
		} catch (IOException ex) 
		{
			System.out.println("");
	        LOGGER.warning("Error: " + ex.getMessage() + " +readIndividualElementsFromFile()");
		} 
		return null;
	}
	
}
