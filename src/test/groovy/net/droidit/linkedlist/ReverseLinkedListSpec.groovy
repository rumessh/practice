package net.droidit.linkedlist

import spock.lang.Specification;

class ReverseLinkedListSpec extends Specification {
	
	def "Testing the linked list reverse program" () {
		given:
			def rand = new Random()
			def head = new ListNode<Integer>(rand.nextInt(11))
			def curr = head
			def total = rand.nextInt(11) + 1
			def expectedNode = null
			for(int i=0;i< total; ++i) {
				curr.next = new ListNode<Integer>(rand.nextInt(11))
				curr = curr.next 
				expectedNode = curr
			}
			def result = null
		when:
			result = ReverseLinkedList.reverse(head)
		then:
			result.data == expectedNode.data
	}
}
