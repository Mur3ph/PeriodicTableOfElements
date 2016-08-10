package ie.murph.model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadingElements {

	public List<String> readElementsFromFile()
	{
		try (Stream<String> stream = Files.lines(Paths.get("File/periodic-table-of-elements.csv"),Charset.defaultCharset())) 
		{
            //stream.forEach(System.out::println);
			return putDataIntoList(stream);
		} catch (IOException ex) 
		{
	        System.out.println("Error: " + ex.getMessage());
		} 
		return null;
	}
	
	private List<String> putDataIntoList(Stream<String> stream)
	{
		List<String> list = new ArrayList<>();		
		list = stream
			    .map(line -> Arrays.asList(line.split(","))) // This without the below line will get all the data in a list of lists
			    .map(lists -> {String movie=lists.get(0).trim(); return movie;}) //This gets a certain data in whatever position we want
			    .collect(Collectors.toList());	
//		list.forEach(System.out::println);
		return list;
	}
	
}