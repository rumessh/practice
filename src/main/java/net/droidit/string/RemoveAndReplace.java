package net.droidit.string;

import java.util.HashMap;
import java.util.Map;

public class RemoveAndReplace {
    
    public static void replaceAndRemove(char[] s) {
    	
    	Map<Character, String> symbolMap = new HashMap<>();
    	
    	symbolMap.put('.', "DOT");
        symbolMap.put('!', "EXCLAMATORY MARK");
        symbolMap.put('?', "QUESTION MARK");
        
        int size = new String(s).trim().length();
        int i = 0;
        int symbolNameLength = 0, extraLength = 0, writeIndex = 0;
        String symbolName = null;
        while(i < size) {
            if(symbolMap.containsKey(s[i])) {
                extraLength += symbolMap.get(s[i]).length()-1;
            }
            i++;
        }
        i = i-1;
        writeIndex = size + extraLength - 1;
        while(i >= 0) {
            if(symbolMap.containsKey(s[i])) {
                symbolName = symbolMap.get(s[i]);
                symbolNameLength = symbolName .length()-1;
                while(symbolNameLength >=0) {
                    s[writeIndex--] = symbolName.charAt(symbolNameLength--);
                }
            }
            else {
            	s[writeIndex--] = s[i];
            }
            
            i--;
        }
    }
}