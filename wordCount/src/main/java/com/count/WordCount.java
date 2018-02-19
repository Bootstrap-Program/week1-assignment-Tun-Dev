package com.count;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {

	public Map<Integer, List<String>> wordCountWithDuplicate(String word) {
		List<String> longest = new ArrayList<String>();
		List<Integer> lengthList = new ArrayList<Integer>();
		Map<Integer, List<String>> wordMap = new HashMap<Integer, List<String>>();
		String[] nos = word.trim().split("\\s+");
		for (String f : nos) {
			lengthList.add(f.length());
		}

		int maxLength = Collections.max(lengthList);
		int anyDuplicate = Collections.frequency(lengthList, maxLength);

		if (anyDuplicate > 1) {
			for (int f=0; f < lengthList.size(); f++) {
				if (lengthList.get(f) == maxLength) {
					longest.add(nos[f]);
				}
			}
		} else {
			longest.add(nos[lengthList.indexOf(maxLength)]);
		}
		wordMap.put(maxLength, longest);
		return wordMap;
	}

//	public Map<Integer, String> wordCount(String word) {
//
//		List<Integer> lengthList = new ArrayList<Integer>();
//		Map<Integer, String> wordMap = new HashMap<Integer, String>();
//		String[] nos = word.trim().split("\\s+");
//		for (String f : nos) {
//			lengthList.add(f.length());
//		}
//
//		int maxLength = Collections.max(lengthList);
//		int wordIndex = lengthList.indexOf(maxLength);
//
//		wordMap.put(maxLength, nos[wordIndex]);
//		return wordMap;
//	}

}
