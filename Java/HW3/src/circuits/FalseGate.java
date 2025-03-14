package circuits;

public class FalseGate extends Gate{
	// implementation of False gate
	private static Gate instance = null;
	
	private FalseGate(Gate[] inGates) {
		super(inGates);
	}
	
	public static Gate instance() {
		if (instance == null) {
			instance = new FalseGate(null);
		}
		return instance;
	}
	
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return false;
	}

	@Override
	public String getName() {
		return "F";
	}

	@Override
	public Gate simplify() {
		return this;
	}

}
