package acctMgr.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import acctMgr.model.Account;
import acctMgr.model.AccountList;

class AccountListTest {
	
	AccountList accountlist = new AccountList();

	@Before
	public void setUp() throws Exception 
	{
	}

	@After
	public void tearDown() throws Exception 
	{
		accountlist = null;
		System.gc();
	}
	
	@Test
	public void readTestNotNull() throws Exception {
	    accountlist.readFromFile("inputFile.txt");
	    assertNotNull(accountlist);
	}
	
	@Test
	public void readTestContents() throws Exception 
	{
		try {
			accountlist.readFromFile("inputFile.txt");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(accountlist.getName(0).toString(), "Colten");
		assertEquals(accountlist.getID(0).toString(), "123456");
		assertEquals(accountlist.getBalance(0).toString(), "990935.32" );
		assertEquals(accountlist.getName(1).toString(), "Natalie");
		assertEquals(accountlist.getID(1).toString(), "34567");
		assertEquals(accountlist.getBalance(1).toString(), "38532.23" );
		assertEquals(accountlist.getName(2).toString(), "Lacey");
		assertEquals(accountlist.getID(2).toString(), "564");
		assertEquals(accountlist.getBalance(2).toString(), "45634.33" );
	}
	
	@Test
	public void testAddAccount() throws Exception
	{
		accountlist.readFromFile("inputFile.txt");
		accountlist.addAccount("person4", "9939", new BigDecimal("99999.33"));
		assertEquals(accountlist.getName(3).toString(), "person4");
		assertEquals(accountlist.getID(3).toString(), "9939");
		assertEquals(accountlist.getBalance(3).toString(), "99999.33");
	}
	
	@Test
	public void testRemoveAccount() throws Exception
	{
		accountlist.readFromFile("inputFile.txt");
		accountlist.removeAccount(0);
		assertNotEquals(accountlist.getName(0).toString(), "Colten");
		assertNotEquals(accountlist.getID(0).toString(), "123456");
		assertNotEquals(accountlist.getBalance(0).toString(), "990935.32");
		
	}
}
