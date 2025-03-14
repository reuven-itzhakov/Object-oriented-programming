package tasks;

public class Tasks {
	// class that representing tasks
	// in this class we are going to implement topological sorting using DFS algorithm
	// that we have studied at Algorithms course.
	
	// initializing constants so the code will be more readable
	private static final int NO = 0;
	private static final int TREE = 4;
	private static final int FORWARD = 1;
	private static final int INTERSECT = 2;
	private static final int BACKWARD = 3;
	// the colors for the nodes
	private static final int WHITE = 0;
	private static final int RED = 1;
	private static final int BLACK = 2;

	// 
	private int cnt; // index to be inserted to lst
	private int[] lst; // will be list of sorted tasks after the DFS 
	private int num; // number of tasks
	private int time; // helps update d and f lists
	private int[] d; // time of discovery 
	private int[] f; // time of finish
	private boolean hasLoops; // true if a loop is discovered 
	private int[][] graph; // matrix of neighbors
	private int[] color; // list of color for each node

	
	public Tasks(int num) {
		this.num = num;
		graph = new int[num][num];
		color = new int[num];
		d = new int[num];
		f = new int[num];
		lst = new int[num];
		cnt = num - 1;
	}

	public boolean dependsOn(int task1, int task2) {
		// check the validation of tasks
		// and make dependencies using the graph list
		if (0 <= task1 && task1 < num && 0 <= task2 && task2 < num && task1 != task2) {
			graph[task2][task1] = 1;
			return true;
		}
		return false;
	}

	private void DFS() {
		// DFS algorithm
		for (int i = 0; i < num; i++) {
			color[i] = WHITE;
		}
		time = 0;
		for (int i = 0; i < num; i++) {
			if (color[i] == WHITE) {
				DFS_VISIT(i);
			}
		}
	}

	private void DFS_VISIT(int n) {
		// part of DFS algorithm
		color[n] = RED;
		d[n] = ++time;
		for (int i = 0; i < num; i++) {
			if (graph[n][i] > NO) {
				if (color[i] == WHITE) {
					graph[n][i] = TREE;
					DFS_VISIT(i);
				} else if (color[i] == RED) {
					graph[n][i] = BACKWARD;
					hasLoops = true;
				} else if (color[i] == BLACK) {
					graph[n][i] = d[n] < d[i] ? INTERSECT : FORWARD;
				}
			}
		}
		lst[cnt--] = n;
		f[n] = ++time;
		color[n] = BLACK;
	}

	public int[] order() {
		DFS();
		if (hasLoops)
			return null;
		return lst;
	}
}