package tree;

import java.util.Scanner;

public class ReversedWords {
	// a class that check if there a reversed words
	
	public static int checkReversed() {
		Scanner in = new Scanner(System.in);
		Node words = new Node();
		int reversedNum = 0;
		String str;
		while (!(str = in.next()).equals("X")) {
			if (words.num(reversed(str))>0) {
				reversedNum++;
			}
			words.add(str);
		}
		in.close();
		return reversedNum;
	}
	
	private static String reversed(String s) {
		// return the reversed string
		return (new StringBuilder(s)).reverse().toString();
	}
}
