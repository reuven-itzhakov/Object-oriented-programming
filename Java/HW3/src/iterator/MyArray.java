package iterator;

import java.util.NoSuchElementException;

public class MyArray implements MyIterator{
	// an iterator implementation to get a content of an array elements one by one
	private int[] arr;
	private int curr;
	
	public MyArray(int[] arr) {
		this.arr = arr;
	}
	
	@Override
	public boolean hasNext() {
		return curr < arr.length;
	}
	@Override
	public int next(){
		if(!hasNext())
			throw new NoSuchElementException();
		return arr[curr++];
	}
}
