package acctMgr.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account extends AbstractModel {

	private String name;
	private String iD;
	private BigDecimal balance;
	public Account(String name, String iD, BigDecimal balance) {
		this.name = name;
		this.iD = iD;
		this.balance = balance;
		this.balance.setScale(2, RoundingMode.HALF_UP);
	}
	
	public String getName(){return name;}
	public String getID(){return iD;}
	public BigDecimal getBalance(){return balance;}
	
	public void deposit(BigDecimal amount) {
		balance = balance.add(amount);
		balance = balance.setScale(2, RoundingMode.HALF_UP);
	}
	
	public void withdraw(BigDecimal amount) throws OverdraftException{
		BigDecimal a = balance.add(BigDecimal.ZERO);
		a = a.subtract(amount);
		
		if(a.signum() <= 0) 
			throw new OverdraftException(a);
		
		balance = a;
			
	}
	
	// Test within class
	/*public static void main(String[] args) throws OverdraftException {
		Account acc1 = new Account("colten", "123", new BigDecimal(500.23).setScale(2, RoundingMode.HALF_UP));
		System.out.println("starting balance: " + acc1.getBalance());
		acc1.deposit(new BigDecimal("350"));
		System.out.println("after deposit balance: " + acc1.getBalance());
		acc1.withdraw(new BigDecimal("100"));
		System.out.println("after withdrawal balance: " + acc1.getBalance());
		acc1.withdraw(new BigDecimal("1000"));
		System.out.println("after withdrawal balance: " + acc1.getBalance());
		
	}*/
}
