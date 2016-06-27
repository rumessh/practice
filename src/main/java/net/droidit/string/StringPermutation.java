package net.droidit.string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
	private String s;
	
	public StringPermutation(String s) {
		this.s = s;
	}
	
	public List<String> performPermutation() {
		List<String> result = new ArrayList<>();
		permutate("", this.s, result);
		return result;
	}
	
	private void permutate(String prefix, String s, List<String> result) {
		int n = s.length();
		if(n == 0) {
			result.add(prefix);
		}
		else {
			for(int i=0; i<n; i++) {
				permutate(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n), result);
			}
		}
	}
}
