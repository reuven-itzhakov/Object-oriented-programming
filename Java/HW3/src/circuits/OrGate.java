package circuits;

public class OrGate extends Gate {
	// implementation of OR gate
	public OrGate(Gate[] inGates) {
		super(inGates);
	}

	// return true if there is at least one true
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		for(boolean value: inValues) {
			if(value) return true;
		}
		return false;
	}

	@Override
	public String getName() {
		return "OR";
	}

	@Override
	public Gate simplify() {
		if (inGates == null) return null;
		Gate[] simplifiedGates = new Gate[inGates.length];
		int cnt = inGates.length; // after the loop, will be the amount of the gates that are not false
		for(int i = 0,j=0; i < inGates.length;i++) {
			simplifiedGates[j] = inGates[i].simplify();
			if (simplifiedGates[j] instanceof TrueGate) {
				return TrueGate.instance();
			}
			// if the current gate is false, j will not increment, and the next iteration will overwrite this element
			if (simplifiedGates[j] instanceof FalseGate) cnt--;
			else j++;
		}
		if (cnt == 0) {
			return FalseGate.instance();
		}
		if (cnt == 1) {
			return simplifiedGates[0];
		}
		Gate[] newGates = new Gate[cnt];
		for (int i = 0; i<cnt;i++) {
			newGates[i] = simplifiedGates[i];
		}
		return new OrGate(newGates);
	}

}
