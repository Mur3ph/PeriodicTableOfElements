package main.ie.murph.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PlaceElementsIntoDataStructures {
	
	private static final Logger LOGGER = Logger.getLogger(PlaceElementsIntoDataStructures.class.getName());
	private List<String> m_readingElementsFromFileList;
	
	public PlaceElementsIntoDataStructures(List<String> readingElementsFromFileList)
	{
		LOGGER.info("+PlaceElementsIntoDataStructures(List<String> readingElementsFromFileList)");
		this.m_readingElementsFromFileList = readingElementsFromFileList;
	}

	public List<String> putDataIntoList(int number)
	{
		LOGGER.info("+putDataIntoList(int number)");
		List<String> targetList = new ArrayList<>();
		List<String> list = m_readingElementsFromFileList;
		targetList = list.stream()
			    .map(line -> Arrays.asList(line.split(",")))                    // This without the below line will get all the data in a list of lists
			    .map(lists -> {String userChoosesData=lists.get(number).trim(); //This gets a certain data in whatever position we want 
			    return userChoosesData;}) 
			    .collect(Collectors.toList());	
		return targetList;
	}
	
	public List<List<String>> putDataIntoListOfLists()
	{
		LOGGER.info("+putDataIntoListOfLists()");
		List<List<String>> targetList = new ArrayList<>();	
		List<String> list = m_readingElementsFromFileList;
		
		targetList = list.stream()
			    .map(line -> Arrays.asList(line.split(","))) // This without the below line will get all the data in a list of lists
			    .collect(Collectors.toList());	
		return targetList;
	}
	
	// Place data from two lists into a single map, one list for keys and the other for corresponding values. 
	// Key is the name of the element and Value is the attribute of the element the user wants to view
	public Map<String, String> putTwoListsIntoMap(List<String> keys, List<String> values) 
	{
		LOGGER.info("+putTwoListsIntoMap(List<String> keys, List<String> values)");
	    // check preconditions - sizes
	    Map<String, String> map = new HashMap<>();
	    for ( int i = 0; i < keys.size(); i++) {
	        map.put(keys.get(i), values.get(i));
	    }
		return map;
	}
	
	public List<String> getReadingElementsFromFileList() 
	{
		LOGGER.info("+getReadingElementsFromFileList()");
		return m_readingElementsFromFileList;
	}
	
}
