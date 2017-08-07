package com.reselbob.unittestingdemo.mocks;

import java.util.ArrayList;
import java.util.List;
import com.reselbob.unittestingdemo.dao.ListProvider;
/*
 * A class for is a mock used for testing purposes. The class
 * provides behavior for the methods, getStrings() and getNumbers()
 * which is required, according to the definition of ListProvider,
 * the interface implemented by the class
 */
public class MockListProvider implements ListProvider {
	public List<String> getStrings() {
		//Create an ArrayList of values that get returned by
		//the method
		List<String> myList = new ArrayList<String>();
		myList.add("Moe Fine");
		myList.add("Larry Fine");
		myList.add("Shemp Fine");
		myList.add("Joe Besser");
		myList.add("Curly Howard");
		return myList;
	}

	public int[] getNumbers() {
		//create an array of integers that are returned by the
		//function
		return new int[] {4,5,6,7,8,100,200,300};
	}
}
