package net.droidit.heap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestStars {
	
	private PriorityQueue<Star> priorityQueue;
	private int max;
	
	public ClosestStars(int k) {
		priorityQueue = new PriorityQueue<>(k, Collections.reverseOrder());
		max = k;
	}
	
	public List<Star> findClosestStars(ObjectInputStream ois) {
		List<Star> orderedStars = new ArrayList<>(priorityQueue);
		
		try {
			while(true) {
				Star curr = (Star) ois.readObject();
				priorityQueue.offer(curr);
				if(priorityQueue.size() == max + 1 ) {
					priorityQueue.remove();
				}
			}
		} catch(ClassNotFoundException | IOException e) {
			
		}
		
		Collections.sort(orderedStars);
		
		return orderedStars;
	}
}
