import java.util.*;
public class p072 {

	static int N = 1000000;
	public static void main(String[] args) {
		sieve = new int[N+1];  //is prime iff sieve[i] == i
		int sqN = (int)Math.sqrt(N);
		for(int i = 2; i <= N; i++) {
			if(sieve[i] == 0) {
				sieve[i] = i;
				if(i > sqN) continue;
				for(int j = i*i; j <= N; j += i) {
					sieve[j] = i;
				}
			}
		}
		long res = 0;
		for(int i = 2; i <= N; i++) {
			res += phi(i);
		}
		System.out.println(res);
	}
	static int[] sieve;
	static int phi(int n) {
		if(n == 1) return 1;
		int p = sieve[n];
		int res = (p-1);
		n /= p;
		while(n % p == 0) {
			res *= p;
			n /= p;
		}
		return res * phi(n);
	}
	static class Fraction implements Comparable<Fraction>{
		long a, b;
		public Fraction(long a, long b) {
			this.a = a; this.b = b;
			long g = gcd(a, b);
			a /= g; b /= g;
		}
		public Fraction add(Fraction f) {
			return new Fraction(a*f.b + f.a*b, b*f.b);
		}
		public Fraction mult(long x) {
			return new Fraction(a*x, b);
		}
		public Fraction mult(Fraction f) {
			return new Fraction(a*f.a, b*f.b);
		}
		public Fraction inv() {
			return new Fraction(b, a);
		}
		public Fraction div(Fraction f) {
			return mult(f.inv());
		}
		public int compareTo(Fraction f) {
			return Long.compare(a*f.b, f.a*b);
		}
		static long gcd(long a, long b) {
			if(b > a) return gcd(b, a);
			else if(b == 0) return a;
			else return gcd(b, a % b);
		}
		public String toString() {
			return a+"/"+b;
		}
	}

}
