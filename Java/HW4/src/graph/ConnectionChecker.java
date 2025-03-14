package graph;

import java.util.HashSet;
import java.util.Set;

public class ConnectionChecker<V> {
	private GraphInterface<V> g;
	private Set<V> visited;
	public ConnectionChecker(GraphInterface<V> g) {
		this.g = g;
		visited = new HashSet<>();
	}
	
	public boolean check(V v1, V v2) {
		visited.clear();
		return DFS(v1,v2);
	}
	private boolean DFS(V v1, V v2) {
		if(v1.equals(v2)) {
			return true;
		}
		visited.add(v1);
		for(V v:g.neighbours(v1)) {
			if (!visited.contains(v)) {
				if (DFS(v,v2)) return true;	
			}
		}
		return false;
	}
}
