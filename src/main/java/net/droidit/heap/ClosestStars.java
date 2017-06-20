package net.droidit.heap;

import java.util.*;

public class ClosestStars {

	public static List<Star> findCLosestStars(Iterator<Star> stars, int k) {
	    List<Star> closestStars = null;
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        while(stars.hasNext()) {
            Star star = stars.next();
            maxHeap.add(star);

            if(maxHeap.size() == k + 1) {
                maxHeap.remove();
            }
        }

        closestStars = new ArrayList<>(maxHeap);

        Collections.sort(closestStars);

        return closestStars;
    }
}

class Star implements Comparable<Star> {

    private int x;
    private int y;
    private int z;

    public Star(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public int compareTo(Star s) {
        return Double.compare(this.distance(), s.distance());
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}