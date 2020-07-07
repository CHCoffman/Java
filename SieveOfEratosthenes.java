/*
 * @author Colten Coffman
 * 7/7/2020
 * Program that will output all prime numbers up to a given upper bound 
 * (integer N which is a program input) in a computationally efficient 
 * manner using Euler’s sieve algorithm.
 */
package primeNumbers;

public class SieveOfEratosthenes 
{
	
	 /* Creates bool array "prime[0 to n] and
	 * makes all entries true. A value in prime[i]
	 * will be false if i is not a prime */
	void sieveOfEratosthenes(int n)
	{
			boolean prime[] = new boolean[n + 1];
			for(int i = 0; i < n; i++)
				prime[i] = true;
			
			for(int p = 2; p * p <= n; p++)
			{
				// If prime[p] isn't changed, it's prime
				if(prime[p] == true)
				{
					// Update all multiples of p
					for(int i = p * p; i <= n; i += p)
						prime[i] = false;
				}
			}
			
			// Print primes
	        for(int i = 2; i <= n; i++) 
	        { 
	            if(prime[i] == true) 
	                System.out.print(i + " "); 
	        } 
	}
	
	/* Tests the created Sieve of Eratosthenes*/
	public static void main(String[] args) {
		int n = 50;
		System.out.print("Here are the prime numbers ");
		System.out.println("that are less than or equal to " + n);
		SieveOfEratosthenes a = new SieveOfEratosthenes();
		a.sieveOfEratosthenes(n);
}


	

}
