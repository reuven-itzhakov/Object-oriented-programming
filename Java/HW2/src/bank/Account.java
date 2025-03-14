package bank;

public class Account {
	// this is a class to represent a bank account
	private int shekels;
	private String name;
	
	public Account(String name){
		this.name = name;
		shekels = 0;
	}
	public int getShekels(){
		return shekels;
	}
	public String getName(){
		return name;
	}
	public void add(int amount){
		shekels += amount;
	}
	public String toString(){
		return String.format("%s has %d shekels", name, shekels);
	}
}
