package com.reselbob.unittestingdemo.tests;

import static org.easymock.EasyMock.expect;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import com.reselbob.unittestingdemo.dao.ListProvider;
import com.reselbob.unittestingdemo.factories.ListFactory;
import org.junit.Rule;
import org.junit.Test;
/*
 * This test uses EasyMock to create the mock within the scope
 * of the test.
 */
public class ListFactoryEasyMockTest extends EasyMockSupport {
	@Rule
	public EasyMockRule rule = new EasyMockRule(this);

	@Test
	public void CanGetStringsFromFactoryUsingMock() {
		ListProvider mockListProvider = mock(ListProvider.class);
		ListFactory listFactory = new ListFactory(mockListProvider); 
		
		//set up the data for the mock
		List<String> cartoons = new ArrayList<String>();
		cartoons.add("Bugs Bunny");
		cartoons.add("Elmer Fudd");
		
		//setup the mock behavior
		expect(mockListProvider.getStrings()).andReturn(cartoons).times(1);
        //run the mock
		replayAll();
		//call the factory
		List<String>  strings = listFactory.getStrings();
		//verify that the mock was called
		verifyAll();
		
		//do the assertions
		assertTrue(strings.contains("Bugs Bunny"));
		assertTrue(strings.contains("Elmer Fudd"));
	}
}