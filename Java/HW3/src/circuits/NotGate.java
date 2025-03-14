package circuits;

public class NotGate extends Gate {
	
	public NotGate(Gate inGate) {
		super(new Gate[] {inGate});
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return !inValues[0]; // invert the input value
	}

	@Override
	public String getName() {
		return "NOT";
	}

	
	@Override
	public Gate simplify() {
		if(inGates == null) return null;
		Gate simplified = inGates[0].simplify();
		// if the input is a Not gate,
		// return the input value itself
		if (simplified instanceof NotGate) {
			return simplified.inGates[0];
		}
		if (simplified instanceof FalseGate) {
			return TrueGate.instance();
		}
		if (simplified instanceof TrueGate) {
			return FalseGate.instance();
		}
		return new NotGate(simplified);
	}

}
