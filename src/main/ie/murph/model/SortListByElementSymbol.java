package main.ie.murph.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortListByElementSymbol 
{
	private List<String> m_list = new ArrayList<String>();
	private String m_elementSymbol;
	
	public SortListByElementSymbol(String elementSymbol, List<String> list)
	{
		this.m_list = list;
		this.m_elementSymbol = elementSymbol;
	}
	
	public List<String> refineList()
	{
		List<String> list = this.m_list.stream()
				.filter(x -> x.equals(this.m_elementSymbol))
				.collect(Collectors.toList());
		return list;
	}
}
