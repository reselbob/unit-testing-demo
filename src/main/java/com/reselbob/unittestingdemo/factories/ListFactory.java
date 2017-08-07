package com.reselbob.unittestingdemo.factories;

import java.util.List;
import com.reselbob.unittestingdemo.dao.ListProvider;

public class ListFactory {
	
	private ListProvider provider;
	//hide the default constructor
	@SuppressWarnings("unused")
	private ListFactory(){};
	
	//make the constructor to inject the List Provider
	public ListFactory(ListProvider listProvider){
		provider = listProvider;
	}
	
	public List<String> getStrings(){
		return provider.getStrings();
	}
	
	public int[] getNumbers(){
		return provider.getNumbers();
	}
	
	public static String getVersionInfo(){
		return "v 2.0.0";
	}
}
