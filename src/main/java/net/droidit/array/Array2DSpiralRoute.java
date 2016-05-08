package net.droidit.array;

import java.util.ArrayList;
import java.util.List;

public class Array2DSpiralRoute {
	
	public static List<Integer> findSpiralRoute(List<List<Integer>> squareMatrix) {
		List<Integer> spiralPath = new ArrayList<Integer>();
		for(int start = 0; start< Math.ceil(0.5*squareMatrix.size()); ++start) {
			spiralPathFinderHelper(squareMatrix, start, spiralPath);
		}
		return spiralPath;
	}
	
	private static void spiralPathFinderHelper(List<List<Integer>> squareMatrix, int start, List<Integer> path) {
		int end = squareMatrix.size()-start-1;
		if(start == Math.floorDiv(squareMatrix.size(), 2)) {
			path.add(squareMatrix.get(start).get(start));
			return;
		}
		
		for(int i = start; i< end;++i){
			path.add(squareMatrix.get(start).get(i));
		}
		
		for(int i= start; i< end;++i){
			path.add(squareMatrix.get(i).get(end));
		}
		
		for(int i=end;i>start;--i){
			path.add(squareMatrix.get(end).get(i));
		}
		
		for(int i=end;i>start;--i) {
			path.add(squareMatrix.get(i).get(start));
		}
	}
}
