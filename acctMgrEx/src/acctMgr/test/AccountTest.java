package acctMgr.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import acctMgr.model.Account;
//import acctMgr.model.OverdraftException;

class AccountTest {
	Account acc1 = new Account("Colten", "123", new BigDecimal("500.23"));
	
	@Before
	public void setUp() throws Exception 
	{
		Account acc1;
	}

	@After
	public void tearDown() throws Exception 
	{
		acc1 = null;
		System.gc();
	}
	
	@Test
	public void testDeposit() throws Exception 
	{

		acc1.deposit(new BigDecimal("350.00"));
		System.out.println("after deposit balance: " + acc1.getBalance());
		assertEquals(acc1.getBalance().toString(), "850.23");
	}
	
	@Test
	public void testWithdraw() throws Exception 
	{
		acc1.withdraw(new BigDecimal("100.00"));
		System.out.println("after withdrawal balance: " + acc1.getBalance());
		assertEquals(acc1.getBalance().toString(), "400.23");
	}
	

	@Test
	public void testOverdrawException()
	{
		try
		{
			acc1.withdraw(new BigDecimal("1000"));
			fail("Exception Test Fail");
		}
		catch(acctMgr.model.OverdraftException e) 
		{
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(), "Overdrafted account by: -499.77");
			assertTrue(true);
		}
	}
}
