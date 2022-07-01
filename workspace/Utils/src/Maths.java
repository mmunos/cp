import java.util.*;
public class Maths {

	static int N = 1100;
	public static void main(String[] args) {
		int[] sieve = new int[N+1];  //is prime iff sieve[i] == i
		int sqN = (int)Math.sqrt(N);
		long max = 1000000000000000000L;
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i = 2; i <= N; i++) {
			if(sieve[i] == 0) {
				primes.add(i);
				sieve[i] = i;
				if(i > sqN) continue;
				for(int j = i*i; j <= N; j += i) {
					sieve[j] = i;
				}
			}
		}
		System.out.println(primes);
		long curr = 1;		
		int count = 1;
		for(int p: primes) {
			System.out.println(count+" "+p);
			count++; if(count > 44) return;
		}
		for(int p: primes) {
			if(curr > max / p) {
				System.out.println(count+": "+p+" "+curr); 
				curr = 1; count++;
			}
			curr *= p;
		}
	}

}
