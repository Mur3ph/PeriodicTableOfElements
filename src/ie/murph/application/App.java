package ie.murph.application;

import java.util.List;

import ie.murph.model.ReadingElements;

public class App {

	public static void main(String[] args)
	{
		ReadingElements read = new ReadingElements();
		List<String> list1 = read.readIndividualElementsFromFile();
		List<List<String>> list2 = read.readAllElementsFromFile();
		list2.forEach(System.out::println);
	}
}
