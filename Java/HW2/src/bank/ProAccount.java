package bank;

public class ProAccount extends Account {
	// a class that represents an account with transaction history
	private int[] history;
	private int transactions;
	
	public ProAccount(String name) {
		super(name);
		history = new int[100];
		transactions = 0;
	}
	
	@Override
	public void add(int amount) {
		super.add(amount);
		// push to a stack
		history[transactions++]=this.getShekels();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(" [");
		for (int i=0;i<transactions;i++) {
			// add a comma before every element except the first one
			if(i!=0)
				sb.append(",");
			sb.append(history[i]);
		}
		return sb.append("]").toString();
	}
	
	
	// this method is static because it is a utility function
	// it performs generic operations that are not tied to specific instance
	public static void transfer(ProAccount from, ProAccount to, int amount) {
		from.add(-amount);
		to.add(amount);
	}
	
//  this is also a valid non-static solution
//	public void transfer(ProAccount to, int amount) {
//		this.add(-amount);
//		to.add(amount);
//	}
}
