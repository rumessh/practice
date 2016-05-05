package net.droidit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MazeSearch {

	public static class Coordinate {
		int x, y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this == o ) {
				return true;
			}
			
			if(o == null || o.getClass() != this.getClass()) {
				return false;
			}
			
			Coordinate c = (Coordinate) o;
			
			if(x != c.x || y != c.y) {
				return false;
			}
			return true;
		}
		
		@Override
		public String toString() {
			return x + " "+y;
		}
	}
	
	public static enum Color {WHITE, BLACK}
	
	public static boolean searchMaze(List<List<Color>> maze, Coordinate s, Coordinate e, List<Coordinate> path) {
		
		if(s.equals(e)) {
			path.add(e);
			return true;
		}
		
		if(isFeasible(s, maze)) {
			path.add(s);
			//Mark as visited
			maze.get(s.x).set(s.y, Color.BLACK);
			List<List<Integer>> SHIFT = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(0, -1),
					Arrays.asList(1, 0), Arrays.asList(-1, 0));
			for(List<Integer> sl: SHIFT) {
				Coordinate next = new Coordinate(s.x + sl.get(0), s.y + sl.get(1));
				if(searchMaze(maze, next, e, path)) {
					return true;
				}
			}
			path.remove(path.size()-1);
		}

		return false;
	}
	
	private static boolean isFeasible(Coordinate curr, List<List<Color>> maze) {
		return curr.x >= 0 && curr.x < maze.size() && curr.y >= 0 && curr.y < maze.get(curr.x).size() && maze.get(curr.x).get(curr.y) == Color.WHITE;
	}
	
	public static void main(String[] args) {
	    Random r = new Random();
	    for (int times = 0; times < 1000; ++times) {
	      int n, m;
	      if (args.length == 2) {
	        n = Integer.parseInt(args[0]);
	        m = Integer.parseInt(args[1]);
	      } else {
	        n = r.nextInt(30) + 1;
	        m = r.nextInt(30) + 1;
	      }
	      List<List<Color>> maze = new ArrayList<>(n);
	      for (int i = 0; i < n; ++i) {
	        maze.add(new ArrayList<Color>(m));
	        for (int j = 0; j < m; ++j) {
	          maze.get(i).add(Color.values()[r.nextInt(2)]);
	        }
	      }
	      List<Coordinate> white = new ArrayList<>();
	      for (int i = 0; i < n; ++i) {
	        for (int j = 0; j < m; ++j) {
	          if (maze.get(i).get(j) == Color.WHITE) {
	            white.add(new Coordinate(i, j));
	          }
	          System.out.print(maze.get(i).get(j) + " ");
	        }
	        System.out.println();
	      }
	      System.out.println();
	      if (white.size() != 0) {
	        int start = r.nextInt(white.size());
	        int end = r.nextInt(white.size());
	        System.out.println("Start" + white.get(start));
	        System.out.println("End" + white.get(end));
	        List<Coordinate> path = new ArrayList<Coordinate>();
	        boolean isPathFound = searchMaze(maze, white.get(start), white.get(end), path);
	        if (isPathFound) {
	          assert(white.get(start).equals(path.get(0))
	                 && white.get(end).equals(path.get(path.size() - 1)));
	        }
	        Coordinate prev = null;
	        for (Coordinate curr : path) {
	          if (prev != null) {
	            assert(Math.abs(prev.x - curr.x) + Math.abs(prev.y - curr.y) == 1);
	          }
	          prev = curr;
	          System.out.println("(" + curr.x + "," + curr.y + ")" + isPathFound);
	        }
	      }
	    }
	  }
}
