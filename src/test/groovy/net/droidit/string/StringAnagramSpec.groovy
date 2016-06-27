package net.droidit.string

import spock.lang.Specification;

class StringAnagramSpec extends Specification {

	def "Checks anagrams for strings of equal length" () {
		given:
			def s1 = "ananya"
			def s2 = "aannay"
			StringAnagram sa = new StringAnagram(s1, s2)
		when:
			def result = sa.areAnagrams();
		then:
			result == true
	}
	
	def "Checks anagrams for strings of different length" () {
		given:
			def s1 = "ananya"
			def s2 = "aanny"
			StringAnagram sa = new StringAnagram(s1, s2)
		when:
			def result = sa.areAnagrams();
		then:
			result == false
	}
	
	def "Checks anagrams for null string" () {
		given:
			def s1 = "ananya"
			def s2 = null
			StringAnagram sa = new StringAnagram(s1, s2)
		when:
			def result = sa.areAnagrams();
		then:
			result == false
	}
}
