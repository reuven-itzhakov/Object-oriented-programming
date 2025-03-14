package circuits;

public abstract class Gate {
	// a class that represents a basic logic gate
	protected Gate[] inGates;
	public Gate(Gate[] inGates) {
		this.inGates = inGates;
	}
	// calculates the output of the gate
	public boolean calc() throws CircuitException{
		boolean values[] = null;
		if(inGates != null) {
			values = new boolean[inGates.length];
			for(int i =0; i<inGates.length;i++) {
				values[i] = inGates[i].calc();
			}
		}
		return func(values);
	}
	protected abstract boolean func(boolean[] inValues) throws CircuitException;
	public abstract String getName();
	public abstract Gate simplify();
	
	// returns a string representation of the gate and its inputs, recursively
	public String toString() {
		StringBuilder sb =new StringBuilder(getName());
		if(inGates != null) {
			sb.append("[");
			int i = 0;
			for(Gate g : inGates) {
				if (i++!=0) sb.append(", ");
				sb.append(g.toString());
			}
			sb.append("]");
		}
		return sb.toString();
	}
}
