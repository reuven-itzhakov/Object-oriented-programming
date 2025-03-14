package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Maze implements GraphInterface<Place>{
	// Class that representing a maze
	private int size;
	private Place start, end;
	private Set<Place> walls; // walls stored as a set of x,y coordinates

	public Maze(int size, int startx, int starty, int endx, int endy) {
		this.size = size;
		start = new Place(startx, starty, size);
		end = new Place(endx, endy, size);
		walls = new HashSet<>();
	}

	public boolean addWall(int x, int y) {
		// adds wall using x,y coordinates to the maze
		Place wall = new Place(x, y, size);
		if (walls.contains(wall) || wall.equals(start) || wall.equals(end))
			return false;
		walls.add(wall);
		return true;
	}

	public String toString() {
		// prints the maze when "S" representing the start position
		// "E" representing the end position
		// "@" representing a wall
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				Place curr = new Place(x, y, size);
				if (start.equals(curr)) {
					sb.append("S");
					continue;
				}
				if (end.equals(curr)) {
					sb.append("E");
					continue;
				}
				if (walls.contains(curr)) {
					sb.append("@");
					continue;
				}
				sb.append(".");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public boolean isSolvable() {
		Graph<Place> g = new Graph<>();
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				Place curr = new Place(x, y, size);
				// if a wall continue
				if (walls.contains(curr)) {
					continue;
				}
				// add the vertex
				try {
					g.addVertex(curr);
				} catch (GraphException e) {
				}
				// if up is not a wall add edge
				if (y != 0) {
					Place up = new Place(x, y - 1, size);
					if (!walls.contains(curr)) {
						try {
							g.addEdge(curr, up);
						} catch (GraphException e) {
						}
					}
				}
				// if left is not a wall add edge
				if (x != 0) {
					Place left = new Place(x - 1, y, size);
					if (!walls.contains(curr)) {
						try {
							g.addEdge(curr, left);
						} catch (GraphException e) {
						}
					}
				}
			}
		}
		try {
			return g.connected(start, end);
		} catch (GraphException e) {
			return false;
		}
	}

	@Override
	public Collection<Place> neighbours(Place v) {
		// returns an array of places that is neighbors of the given place
		int x = v.getX();
		int y = v.getY();
		int X[] = {x-1,x,x+1,x};
		int Y[] = {y,y-1,y,y+1};
		Collection<Place> ret = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			if(X[i]>=0 && X[i]<size && Y[i]>=0 && Y[i]<size) {
				Place p = new Place(X[i],Y[i],size);
				if(!walls.contains(p)) {
					ret.add(p);
				}
			}
		}
		return ret;
	}

}
