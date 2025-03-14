package shop;

public class Piano extends Instrument {
	// Class that representing Piano
	private int octaves;
	
	public Piano(String company, int price, int octaves) {
		super(company, price);
		this.octaves = octaves;
	}
	public int getOctaves() {
		return octaves;
	}
	
	@Override
	protected String getProperties() {
		return String.format("%d octaves", octaves);
	}

}
