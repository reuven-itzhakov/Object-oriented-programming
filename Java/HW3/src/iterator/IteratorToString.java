package iterator;

public class IteratorToString {
	// prints an iterator content 
	public static String toString(MyIterator it) {
		StringBuilder sb = new StringBuilder("[");
		int i = 0;
		while(it.hasNext()) {
			if(i!=0) 
				sb.append(' ');
			sb.append(it.next());
			i++;
		}
		return sb.append(']').toString();
	}
}
