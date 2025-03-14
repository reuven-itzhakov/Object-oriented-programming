package circuits;

public class AndGate extends Gate {
	// implementation of AND gate
	public AndGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		for(boolean value:inValues) {
			if(!value) return false;
		}
		return true;
	}

	@Override
	public String getName() {
		return "AND";
	}

	@Override
	public Gate simplify() {
		if (inGates == null) return null;
		Gate[] simplifiedGates = new Gate[inGates.length];
		int cnt = inGates.length; // after the loop, will be the amount of the gates that are not true
		for(int i = 0,j=0; i < inGates.length;i++) {
			simplifiedGates[j] = inGates[i].simplify();
			if (simplifiedGates[j] instanceof FalseGate) {
				return FalseGate.instance();
			}
			// if the current gate is true, j will not increment, and the next iteration will overwrite this element
			if (simplifiedGates[j] instanceof TrueGate) cnt--;
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
		return new AndGate(newGates);
	}

}
