package net.droidit.string

import spock.lang.Specification;

class StringPermutationSpec extends Specification{
	
	def "Tests string permutation"() {
		given:
			def s = "abc"
			StringPermutation sp = new StringPermutation(s)
			def expected = ["abc", "acb", "bac", "bca", "cab", "cba"]
		when:
			def result = sp.performPermutation()
		then:
			expected.sort() == result.sort()
	}
}
