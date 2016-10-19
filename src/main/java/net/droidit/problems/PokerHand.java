package net.droidit.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class PokerHand {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] arr = new String[5];
        String rank = "23456789TJQKA";
        List<Integer> indexArray = new ArrayList<Integer>();
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        int temp = 0;
        char c;
        String result = "";
        for(int j =0; j<5; j++) {
            arr[j] = in.next();
            c = arr[j].charAt(0);
            temp = countMap.get(c) == null ? 0 :  countMap.get(c);
            countMap.put(c, ++temp);
            c = arr[j].charAt(1);
            temp = countMap.get(c) == null ? 0 :  countMap.get(c);
            countMap.put(c, ++temp);
        }
        
        for(Entry<Character, Integer> entry : countMap.entrySet()) {
        	c = entry.getKey();
        	if(Character.isDigit(c) || c == 'T' ||  c == 'A') {
        		if(entry.getValue() == 4) {
        			result = "four-of-a-kind";
        			break;
        		}
        		else if(entry.getValue() == 3) {
        			if(result == "pair") {
        				result = "full-house";
        			}
        			else {
        				result = "three-of-a-kind";
        			}
        		}
        		else if(entry.getValue() == 2) {
        			if(result == "three-of-a-kind") {
        				result = "full-house";
        			}
        			else {
        				result = "pair";
        			}
        		}
        		
        		indexArray.add(rank.indexOf(c));
        		
        	}
        }
        
    	if(result != "four-of-a-kind" && result != "three-of-a-kind") {

    		Collections.sort(indexArray);
    		temp = 0;
            for(int index : indexArray) {
            	//we have to find whetehr the list in sequence;
            }
    	}
        
        for(Entry<Character, Integer> entry : countMap.entrySet()) {
        	c = entry.getKey();
    		if(entry.getValue() == 5) {
    			result = "flush";
    		}
        }
        
        System.out.println(result);
    
    }
}