package main.ie.murph.model;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SortListByElementSymbol 
{
	private static final Logger LOGGER = Logger.getLogger(ReadingElementsFromFile.class.getName());
	private List<String> m_currentList;
	private List<String> m_changedList;
	private String m_elementSymbol;
	private int m_sizeOfSymbol;
	
	public SortListByElementSymbol(String elementSymbol, List<String> list)
	{
		this.m_currentList = list;
		this.m_elementSymbol = ", " + elementSymbol + " ,";
		this.m_sizeOfSymbol = elementSymbol.length()+2;
	}
	
	public void refineList()
	{
		try
		{
			//Just revert back to finding a string in a list loop old school :)
			m_changedList = this.m_currentList.stream()
					.filter(line -> line.substring(line.indexOf(","), line.indexOf(",")+this.m_sizeOfSymbol).trim().contains(this.m_elementSymbol))
					.collect(Collectors.toList());
		}
		catch(Exception e)
		{
			LOGGER.warning("+refineList() Message: " + e.getMessage() + "Hash code: " + e.hashCode());
			e.printStackTrace();
		}
		
	}

	public List<String> getSortedList() 
	{
		return m_changedList;
	}
}
