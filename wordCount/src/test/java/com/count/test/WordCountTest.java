package com.count.test;

import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;


import com.count.WordCount;

public class WordCountTest {
	
	WordCount wordCountObj;

	@Before
	public void setup() {
		wordCountObj = new WordCount();
	}

	@Test
	public void testWordCountNoDuplicateLength() {
		String testString = "my name is Dele and I am 12 years  old";
		Map<Integer, List<String>> mp = wordCountObj.wordCountWithDuplicate(testString);
		List<String> ls = new ArrayList<String>();
		ls.add("years");	
		assertSame(mp.keySet().size(), 1);
		assertSame(mp.keySet().toArray()[0], 5);
		assertTrue(mp.values().contains(ls));
		assertSame(mp.get(mp.keySet().toArray()[0]).size(),1);

	}

	@Test
	public void testWordCountWithDuplicatesLength() {
		String testString = "my name is Dele and I am 12";
		Map<Integer, List<String>> mp = wordCountObj.wordCountWithDuplicate(testString);
		List<String> ls = new ArrayList<String>();
		ls.add("name");
		ls.add("Dele");
		assertSame(mp.keySet().size(), 1);
		assertSame(mp.keySet().toArray()[0], 4);
		assertTrue(mp.values().contains(ls));
		assertSame(mp.get(mp.keySet().toArray()[0]).size(),2);
	}

	@Test
	public void testWordCountWithEmptyString() {
		String testString = "";
		Map<Integer, List<String>> mp = wordCountObj.wordCountWithDuplicate(testString);
		assertSame(mp.keySet().size(), 1);
		assertSame(mp.keySet().toArray()[0], 0);
	}
	
	@Test
	public void testWordCountWithOnlySpace() {
		String testString = " ";
		Map<Integer, List<String>> mp = wordCountObj.wordCountWithDuplicate(testString);
		List<String> ls = new ArrayList<String>();
		ls.add(" ");

		assertSame(mp.keySet().size(), 1);
		assertSame(mp.keySet().toArray()[0], 0);
		assertFalse(mp.values().contains(ls));

	}
	
	@Test
  	public void testSafeCredential() {
    		System.out.println("Username is " + System.getProperty("uName"));
    		System.out.println("Passcode is " + System.getProperty("pswd"));
  }

}
