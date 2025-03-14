package root;

public class Rooter {
	// a class that approximates a square root of a number
	private double precision;
	
	public void setPrecision(double precision) {
		this.precision = precision;
	}
	
	public Rooter(double precision) {
		this.precision = precision;
	}
	
	public double sqrt(double x) {
		// the algorithm mentioned in the question
		double one=x/2,two=0;
		while(Math.abs(one-two) > this.precision) {
			two = x/one;
			one = (one + two)/2;
		}
		return one;
	}
	
}
