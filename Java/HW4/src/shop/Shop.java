package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	// Class that representing shop
	private ArrayList<Instrument> stock; // store all the instruments in the shop as a list
	private int guitarNum;
	public Shop() {
		stock = new ArrayList<Instrument>();
		guitarNum = 0;
	}
	public void add(Instrument i) {
		// adds new instrument to the stock
		stock.add(i);
		if(i instanceof Guitar) {
			guitarNum++;
		}
	}
	public Instrument get(int serial) {
		// gets serial number of an instrument
		for(Instrument i :stock) {
			if(i.getSerial() == serial)
				return i;
		}
		return null;
	}
	public List<Integer> allSerials() {
		// return a list of integers representing serials of all instruments
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(Instrument i :stock) {
			ret.add(i.getSerial());
		}
		return ret;
	}
	public List<Integer> guitarsOfType(Type t){
		// returns a list of integers representing serials of guitars with the given type
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(Instrument i :stock) {
			if(i instanceof Guitar) {
				if(t.equals(((Guitar)i).getType()))
					ret.add(i.getSerial());
			}
		}
		return ret;
	}
	public void sell(int serial) throws MusicShopException{
		// sell an instrument by his serial number (remove from the shop)
		Instrument toSell = get(serial);
		if(toSell == null)
			throw new MusicShopException("Can't sell: there is no instrument with serial of " + serial);
		// check so the last guitar will not sold
		if(toSell instanceof Guitar) {
			if(guitarNum == 1) 
				throw new MusicShopException("Can't sell: there is only one guitar left, it's not for sale");
			guitarNum--;
		}
		stock.remove(toSell);
	}
	
	public int sellAll(int[] serials) {
		// sell of the instruments by their serial numbers using the given array
		int cnt = 0;
		for(int serial:serials) {
			try {
				sell(serial);
			}catch (MusicShopException e){
				 cnt++;
			}
		}
		return cnt;
	}
}
