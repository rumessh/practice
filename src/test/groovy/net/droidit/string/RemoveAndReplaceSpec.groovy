package net.droidit.string

import spock.lang.Specification;

class RemoveAndReplaceSpec extends Specification {
	
	def "Testing string remove and replace" () {
		given:
			def charString = "abcdefghijklmnopqrstuvwxyz.?!"
			Random rand = new Random()
			def siz = rand.nextInt(21);
			def charArray = new char[(siz << 2)+1];
			for(int i=0;i< siz; i++) {
				charArray[i] = charString.charAt(rand.nextInt(siz))
			}
			def result = new String(charArray).replaceAll("\\.", "DOT").replaceAll("\\!", "EXCLAMATORY MARK").replaceAll("\\?", "QUESTION MARK")
		when:
			RemoveAndReplace.replaceAndRemove(charArray)
		then:
			result.trim() == new String(charArray).trim()
	}
}
