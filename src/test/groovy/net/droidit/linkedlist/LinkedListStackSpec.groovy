package net.droidit.linkedlist

import spock.lang.Specification;

class LinkedListStackSpec extends Specification {
	
	def "Testing the linked list stack implementation" () {
		given:
			LinkedListStack<Integer> stack = new LinkedListStack<>()
			Random rand = new Random()
			int size = rand.nextInt(21)
			StringBuilder builder = new StringBuilder()
			
			rand.ints(size, 1, 10).forEach{i -> stack.push(i); builder.append(i) }
		when:
			def result = stack.toString()
		then:
			result == builder.reverse().toString()
	}
}
