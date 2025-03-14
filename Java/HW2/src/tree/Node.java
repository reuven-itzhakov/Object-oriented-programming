package tree;

public class Node {
	// a class that represented a tree node
	private int count;
	private Node[] children;
	
	public Node() {
		count = 0;
		children = new Node[26];
	}
	
	public int num(String s) {
		// a recursive method that returns the count of the string s
		// appearance in the tree
		if (s.length()==0) {
			return count;
		}
		if (children[s.charAt(0)-'a']==null) {
			return 0;
		}
		return children[s.charAt(0)-'a'].num(s.substring(1));
	}
	
	public void add(String s) {
		// a recursive method that add string s to the tree
		if (s.length()==0) {
			count++;
			return;
		}
		if (children[s.charAt(0)-'a']==null) {
			children[s.charAt(0)-'a'] = new Node();
		}
		children[s.charAt(0)-'a'].add(s.substring(1));
	}
}
