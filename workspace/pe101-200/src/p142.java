import java.util.*;

public class p142 {

	public static void main(String[] args) {
		int n = 2000000;
		HashSet<Pair>[] triple = new HashSet[n];
		for(int i = 0; i < n; i++) {
			triple[i] = new HashSet<>();
		}
		int m = 1000;
		for(long x = 1; x < m; x++) {
			for(long y = 1; y < x; y++) {
				if(gcd(x, y) == 1) {
					long a = x*x - y*y;
					long b = 2*x*y;
					long c = x*x + y*y;
					for(long k = 1; c * k < n; k++) {
						triple[(int)(c * k)].add(new Pair(a * k, b * k));
					}
				}
			}
		}
		for(int i = 0; i < n; i++) {
			if(!triple[i].isEmpty()) {
				for(Pair p: triple[i]) {
					for(Pair q: triple[(int)p.a]) {
						check(i, q.a, p.a);
						check(i, q.b, p.a);
					}
					for(Pair q: triple[(int)p.b]) {
						check(i, q.a, p.b);
						check(i, q.b, p.b);
					}
				}
			}
		}
	}
	static void check(long a, long b, long c) {
		if((a * a + b * b) % 2 == 1) return;
		long x = (a * a + b * b)/2;
		long y = a * a - x;
		if(y >= x) return;
		long z = c * c - x;
		if(z < 0 || z >= y) return;
		if(issq(x - z)) {
			System.out.println(x+" "+y+" "+z+": "+(x+y+z));
		}
	}
	static boolean issq(long x) {
		long sqx = (long)Math.sqrt(x);
		return sqx * sqx == x;
	}
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
	}
	
	static class Pair{
		long a, b;
		public Pair(long a, long b) {
			if(a < b) {
				this.a = a; this.b = b;
			}
			else {
				this.a = b; this.b = a;
			}
		}
		@Override
		public int hashCode() {
			return (int)(a << 16 + b);
		}
		@Override
		public boolean equals(Object o) {
			Pair p = (Pair)o;
			return a == p.a && b == p.b;
		}
		public String toString() {
			return a+" "+b;
		}
	}

}
