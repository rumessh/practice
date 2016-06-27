package net.droidit.heap;

public class Star implements Comparable<Star> {
	private double x;
	private double y;
	private double z;
	
	public double getDistance() {
		return Math.sqrt(x*x + y*y + z*z);
	}

	@Override
	public int compareTo(Star o) {
		return Double.compare(this.getDistance(), o.getDistance());
	}
}
