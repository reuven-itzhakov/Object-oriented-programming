package shop;

public class Guitar extends Instrument {
	// Class that representing Guitar
	private Type type;
	
	public Guitar(String company, int price, Type type) {
		super(company, price);
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	protected String getProperties() {
		return type.toString();
	}

}
