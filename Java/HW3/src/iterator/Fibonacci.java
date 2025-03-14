package iterator;

public class Fibonacci implements MyIterator{
	// an iterator implementation to get the fibonacci elements one by one
	private int upperBound;
	private int next,curr;
	
	public Fibonacci(int upperBound) {
		this.upperBound = upperBound;
		next = 1;
		curr = 0;
	}

	@Override
	public boolean hasNext() {
		return next < upperBound;
	}

	@Override
	public int next() {
		if (!hasNext())
			return curr;
		int temp = next;
		next += curr;
		curr = temp;
		return curr;
	}
	
	
	
}
