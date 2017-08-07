package com.reselbob.unittestingdemo.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.reselbob.unittestingdemo.dao.ListProvider;
import com.reselbob.unittestingdemo.factories.ListFactory;
import com.reselbob.unittestingdemo.mocks.MockListProvider;

public class ListFactoryTest {
	ListFactory factory;

	@Before
	public void initFactory() {
		ListProvider provider = new MockListProvider();
		factory = new ListFactory(provider);
	}
	
	@After
	public void deleteFactory(){
		factory = null;
	}

	/*
	 * Tests the the private constructor for the ListFactory
	 * fails. Using the parameter, expected in the @Test annotation
	 * checks to see that an error is thrown
	 */
	@Test(expected = java.lang.Error.class)
	public void CannotUseDefaultContructor() {
		ListFactory factory = new ListFactory();
	}
	
	/*
	 * Test to make sure the public constructor works
	 */
	@Test
	public void CanCreateListFactoryInstance(){
		//We need a  mock of ListProvicer to instantiate the
		//ListFactory
		ListProvider provider = new MockListProvider();
		ListFactory listFactory = new ListFactory(provider);
		assertNotNull(listFactory);
	}

	/*
	 * Tests that the public constructor for
	 * the ListFactory works.
	 */
	@Test
	public void CanInjectListProvider() {
		//Instantiate the mock
		ListProvider provider = new MockListProvider();
		//inject the mock into the factory
		ListFactory localFactory = new ListFactory(provider);
		//if you get to here without exception, the instantiation
		//succeeded. Now do a assertion that the return is value
		//is valid
		assertTrue(localFactory instanceof ListFactory);
	}

	/*
	 * Test the ListFactory.getStrings returns a List<String> and the mock
	 * data expected is there
	 */
	@Test
	public void CanGetStringsFromFactory() {
		List<String> strings = factory.getStrings();
		assertTrue(strings.size() > 0);
		assertTrue(strings.contains("Moe Fine"));
		assertTrue(strings.contains("Larry Fine"));
		assertTrue(strings.contains("Shemp Fine"));
		assertTrue(strings.contains("Joe Besser"));
		assertTrue(strings.contains("Curly Howard"));
	}

	/*
	 * Test the ListFactory.getNumbers returns an array of integers
	 * and the returned array equals the expected array
	 * 
	 */
	@Test
	public void CanGetIntsFromFactory() {
		int[] ints = factory.getNumbers();
		int[] expectedValues = new int[] {4,5,6,7,8,100,200,300};
		assertArrayEquals(ints, expectedValues);
	}
	
	@Test
	public void CanGetVersionInfo() {
		String info = ListFactory.getVersionInfo();
		assertTrue(info.length() > 0);
	}
}
