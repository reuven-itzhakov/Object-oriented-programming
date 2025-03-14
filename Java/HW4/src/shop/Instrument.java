package shop;

public abstract class Instrument {
	// Class representing an Instrument
	private String company;
	private int price;
	private int serial;
	private static int id = 0;
	public Instrument(String company, int price) {
		this.company = company;
		this.price = price;
		serial = id++;
	}
	public String getCompany() {
		return company;
	}
	public int getPrice() {
		return price;
	}
	public int getSerial() {
		return serial;
	}
	protected abstract String getProperties();
	
	@Override
	public String toString() {
		return String.format("%s(%s) %s(%d), price = %d",
				getClass().getSimpleName(),
				getProperties(),
				company,serial,price);
	}
}
