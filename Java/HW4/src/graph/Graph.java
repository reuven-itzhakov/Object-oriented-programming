package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Graph<V> {
	// class that representing a graph
	private Set<V> vertices; // vertices stored as a set
	private Map<V, Set<V>> edges; // edges stored as a map with key of vertex to all its neighbors
	public Graph() {
		vertices = new HashSet<>();
		edges = new HashMap<>();
	}
	
	public void addVertex(V v) throws GraphException{
		// adds vertex to the graph
		if(vertices.contains(v))
			throw new GraphException("vertex already exists");
		vertices.add(v);
		edges.put(v, new HashSet<V>());
	}
	public void addEdge(V v1, V v2) throws GraphException{
		// adds edge to the graph
		if(!(vertices.contains(v1) && vertices.contains(v2))) {
			throw new GraphException("vertex does not exist");
		}
		if(edges.get(v1).contains(v2)) {
			throw new GraphException("edge already exists");
		}
		edges.get(v1).add(v2);
		edges.get(v2).add(v1);
	}
	public boolean hasEdge(V v1, V v2) {
		// returns true if there is an edge, else false
		if(!(vertices.contains(v1) && vertices.contains(v2))) {
			return false;
		}
		return edges.get(v1).contains(v2);
	}
	public boolean connected(V v1, V v2) throws GraphException{
		// returns true if two given vertices are connected with other vertices and edges
		if(!(vertices.contains(v1) && vertices.contains(v2))) {
			throw new GraphException("vertex does not exist");
		}
		Set<V> visited = new HashSet<>();
		
		Queue<V> Q = new ConcurrentLinkedQueue<>();
		Q.offer(v1);
		while(!Q.isEmpty()) {
			V curr = Q.poll();
			visited.add(curr);
			for(V v: edges.get(curr)) {
				if (!visited.contains(v)) {
					Q.offer(v);
				}
			}
		}
		return visited.contains(v2);
	}
}
