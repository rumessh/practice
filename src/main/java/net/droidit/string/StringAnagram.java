package net.droidit.string;

public class StringAnagram {

	private String s1;
	private String s2;
	
	public StringAnagram(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	
	public boolean areAnagrams() {
		int n = s1.length();
		int[] count1 = new int[256];
		int[] count2 = new int[256];
		
		if(s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		
		for(int i=0; i<n; i++) {
			count1[s1.charAt(i)]++;
			count2[s2.charAt(i)]++;
		}
		
		for(int i=0; i<256;i++) {
			if(count1[i] != count2[i]) {
				return false;
			}
		}
		return true;
	}
}
