package circuits;

public class TrueGate extends Gate{
	// implementation of True gate
	private static Gate instance = null;
	
	private TrueGate(Gate[] inGates) {
		super(inGates);
	}
	
	public static Gate instance() {
		if (instance == null) {
			instance = new TrueGate(null);
		}
		return instance;
	}
	
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return true;
	}

	@Override
	public String getName() {
		return "T";
	}

	@Override
	public Gate simplify() {
		return this;
	}

}
