import java.math.BigInteger;

import C.B;

public class Combinatorics {
	static long mod = 1000000009;
	static int N = 100000;
	static long[] fac = new long[N+1];
	static long[] invfac = new long[N+1];
	static long fac(int n){
		if(n == 0) return fac[0] = 1;
		else if(fac[n] > 0) return fac[n];
		else return fac[n] = n * fac(n-1) % mod;
	}
	static long invfac(int n){
		if(invfac[n] > 0) return invfac[n];
		else return invfac[n] = inv(fac[n]);
	}
	static long choose(int n, int k){
		return fac(n) * invfac(k) % mod * invfac(n-k) % mod;
	}
	static long inv(long a){
		return (gcdex(a, mod)[0] + mod) % mod;
	}
	static long[] gcdex(long a, long b){
		if(b > a) {
			long[] p = gcdex(b, a);
			return new long[] {p[1], p[0]};
		}
		else if(b == 0) return new long[] {1, 0};
		else{
			long[] p = gcdex(b, a % b);
			return new long[] {p[1], p[0] - p[1]*(a/b)};
		}
	}
	static Pair gcdexp(long a, long b){
		if(b > a) return gcdexp(b, a).invert();
		else if(b == 0) return new Pair(1, 0);
		else{
			Pair p = gcdexp(b, a % b);
			return new Pair(p.s, p.r - p.s*(a/b));
		}
	}
	static class Pair{
		long r, s;
		public Pair(long r, long s){
			this.r = r; this.s = s;
		}
		public Pair invert(){
			return new Pair(s, r);
		}
		public String toString() {
			return r+" "+s;
		}
	}
	
	static long pow(long a, long b) {
		long res = 1;
		while(b > 0) {
			if(b % 2 == 1) {
				res = res * a % mod;
			}
			a = a * a % mod;
			b /= 2;
		}
		return res;
	}
	
	
//	static Pairbig gcdexbig(BigInteger a, BigInteger b){
//		if(gr(b, a)) return gcdexbig(b, a).invert();
//		else if(b.equals(v(0))) return new Pairbig(v(1), v(0));
//		else{
//			Pairbig p = gcdexbig(b, a.mod(b));
//			return new Pairbig(p.s, sub(p.r, m(p.s, div(a, b))));
//		}
//	}
//	static class Pairbig{
//		BigInteger r, s;
//		public Pairbig(BigInteger r, BigInteger s){
//			this.r = r; this.s = s;
//		}
//		public Pairbig invert(){
//			return new Pairbig(s, r);
//		}
//		public String toString() {
//			return r+" "+s;
//		}
//	}
//	static BigInteger v(long x) {
//		return BigInteger.valueOf(x);
//	}
//	static BigInteger s(BigInteger... as) {
//		BigInteger res = v(0);
//		for(BigInteger a: as) {
//			res = res.add(a);
//		}
//		return res;
//	}
//	static BigInteger m(BigInteger... as) {
//		BigInteger res = v(1);
//		for(BigInteger a: as) {
//			res = res.multiply(a);
//		}
//		return res;
//	}
//	static BigInteger sub(BigInteger a, BigInteger b) {
//		return a.subtract(b);
//	}
//	static BigInteger div(BigInteger a, BigInteger b) {
//		return a.divide(b);
//	}
//	static boolean gr(BigInteger a, BigInteger b) {
//		return a.compareTo(b) > 0;
//	}
//	static boolean geq(BigInteger a, BigInteger b) {
//		return a.compareTo(b) >= 0;
//	}
	
	static B v(long x) {
		return new B(BigInteger.valueOf(x));
	} //include this
	static class B{
		BigInteger big;
		public B(BigInteger big) {
			this.big = big;
		}
		public B s(B b) {
			return new B(big.add(b.big));
		}
		public B r(B b) {
			return new B(big.subtract(b.big));
		}
		public B m(B b) {
			return new B(big.multiply(b.big));
		}
		public B d(B b) {
			return new B(big.divide(b.big));
		}
		public boolean gr(B b) {
			return big.compareTo(b.big) > 0;
		}
		public boolean geq(B b) {
			return big.compareTo(b.big) >= 0;
		}
		public String toString() {
			return big.toString();
		}
	}

}
