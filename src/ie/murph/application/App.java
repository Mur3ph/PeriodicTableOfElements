package ie.murph.application;

import java.util.List;

import ie.murph.model.ReadingElements;

public class App {

	public static void main(String[] args)
	{
		ReadingElements read = new ReadingElements();
		List<String> list = read.readElementsFromFile();
		list.forEach(System.out::println);
	}
}
