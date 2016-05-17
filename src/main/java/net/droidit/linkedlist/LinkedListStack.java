package net.droidit.linkedlist;

public class LinkedListStack<T> {
	private ListNode<T> head;
	private int size;
	
	public void push(T data) {
		ListNode<T> temp = head;
		head = new ListNode<T>(data);
		head.next = temp;
		++size;
	}
	
	public ListNode<T> pop() {
		ListNode<T> temp = head;
		if(size !=0){
			head = head.next;
			--size;
		}
		return temp;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		ListNode<T> curr = head;
		while(curr != null) {
			builder.append(curr.data);
			curr = curr.next;
		}
		return builder.toString();
	}
}