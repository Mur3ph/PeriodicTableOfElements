package ie.murph.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlaceElementsIntoDataStructures {

	public List<List<String>> putDataIntoListOfLists(Stream<String> stream)
	{
		List<List<String>> list = new ArrayList<>();		
		list = stream
			    .map(line -> Arrays.asList(line.split(","))) // This without the below line will get all the data in a list of lists
			    .collect(Collectors.toList());	
//		list.forEach(System.out::println);
		return list;
	}
	
	public List<String> putDataIntoList(Stream<String> stream, int number)
	{
		List<String> list = new ArrayList<>();		
		list = stream
			    .map(line -> Arrays.asList(line.split(","))) // This without the below line will get all the data in a list of lists
			    
			    .map(lists -> {String userChoosesData=lists.get(number).trim();//This gets a certain data in whatever position we want 
			    return userChoosesData;}) 
			    .collect(Collectors.toList());	
//		list.forEach(System.out::println);
		return list;
	}
	
}
