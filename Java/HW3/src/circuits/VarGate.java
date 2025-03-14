package circuits;

public class VarGate extends Gate {
	// implementation of Variable gate
	private Boolean value;
	private String name;
	
	public VarGate(String name) {
		super(null);
		this.name=name;
		value = null;
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		if(value == null) {
			throw new CircuitException("variable "+toString()+" has no value");
		}
		return value.booleanValue();
	}

	@Override
	public String getName() {
		return String.format("V%s", name);
	}

	@Override
	public Gate simplify() {
		if(value == null) {
			return this;
		}
		if(value) {
			return TrueGate.instance();
		}
		return FalseGate.instance();
	}
	
	public void setVal(boolean value) {
		this.value = value;
	}

}
