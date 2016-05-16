package net.droidit.linkedlist;

public class ReverseLinkedList {
	public static ListNode<Integer> reverse(ListNode<Integer> head){
		ListNode<Integer> curr = head;
		ListNode<Integer> prev = null;
		while(curr.next != null) {
			ListNode<Integer> temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return curr;
	}
}

class ListNode<T> {
	public ListNode(T data) {
		this.data = data;
	}
	T data;
	public ListNode<T> next;
}