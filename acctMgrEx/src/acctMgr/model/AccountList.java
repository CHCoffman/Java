package acctMgr.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountList {

	public  int numOfAccounts = 0;
	private ArrayList<Account> accounts = new ArrayList<Account>();
		
	public void addAccount(String name, String iD, BigDecimal balance) {
			accounts.add(new Account(name, iD, balance));
			numOfAccounts++;			
		}
	
	public void removeAccount(int i) {
			accounts.remove(i);
			numOfAccounts--;
		}
 
	public void readFromFile(String file) throws FileNotFoundException, NumberFormatException{
		
		File file1 = new File("inputFile.txt");
		Scanner scan = new Scanner(file1);
		while(scan.hasNextLine()) {

			String line = scan.nextLine();
			String[] data = line.split(",");
			String name = data[0].trim();
			String iD = data[1].trim();
			BigDecimal balance = new BigDecimal(data[2]);

			accounts.add(new Account(name, iD, balance));
			numOfAccounts++;			
		}

		scan.close();
		
	}
	public String getName(int index) {return accounts.get(index).getName();}
	public String getID(int index) {return accounts.get(index).getID();}
	public BigDecimal getBalance(int index) {return accounts.get(index).getBalance();}

	public void saveToFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("inputFile.txt"));
			
			for(int i = 0; i < numOfAccounts; i++) {
				String line = accounts.get(i).getName() + ","
						+ accounts.get(i).getID() + "," 
						+ accounts.get(i).getBalance();
				out.write(line);
				out.newLine();
			}
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
} 

}
