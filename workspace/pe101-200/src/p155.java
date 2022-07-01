import java.util.*;
import java.math.*;
public class p155 {

	public static void main(String[] args) {
		int n = 18;
		TreeSet<Fraction>[] sets = new TreeSet[n+1];
		for(int i = 1; i <= n; i++) sets[i] = new TreeSet<>();
		sets[1].add(new Fraction(1, 1));
		long res = 1;
		TreeSet<Fraction> tot = new TreeSet<>();
		tot.add(new Fraction(1, 1));
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j < i; j++) {
				for(Fraction c1: sets[j]) {
					for(Fraction c2: sets[i-j]) {
						Fraction c = c1.add(c2);
						sets[i].add(c);
						Fraction d = c1.inv().add(c2.inv()).inv();
						sets[i].add(d);
					}
				}
			}
			System.out.println(i);
			tot.addAll(sets[i]);
		}
		System.out.println(tot.size());
	}
	
	static class Fraction implements Comparable<Fraction> {
		BigInteger a, b;
		public Fraction(long a, long b) {
			long g = gcd(Math.abs(a), Math.abs(b));
			this.a = v(a / g); this.b = v(b / g);
		}
		public Fraction(BigInteger a, BigInteger b) {
			BigInteger g = a.gcd(b);
			this.a = d(a, g); this.b = d(b, g);
			if(neg(this.b)) {
				this.a = this.a.negate();
				this.b = this.b.negate();
			}
		}
		public Fraction add(Fraction f) {
			return new Fraction(s(m(a,f.b),m(f.a,b)), m(b,f.b));
		}
		public Fraction sub(Fraction f) {
			return add(f.mult(-1));
		}
		public Fraction mult(long x) {
			return new Fraction(m(a,v(x)), b);
		}
		public Fraction mult(Fraction f) {
			return new Fraction(m(a,f.a), m(b,f.b));
		}
		public Fraction inv() {
			return new Fraction(b, a);
		}
		public Fraction div(Fraction f) {
			return mult(f.inv());
		}
		public Fraction abs() {
			if(compareTo(new Fraction(0,1)) >= 0) return this;
			else return mult(-1);
		}
		public int compareTo(Fraction f) {
			BigInteger d = sub(m(a,f.b),m(f.a,b));
			return d.signum();
		}
		static long gcd(long a, long b) {
			if(b > a) return gcd(b, a);
			else if(b == 0) return a;
			else return gcd(b, a % b);
		}
		public String toString() {
			return a+"/"+b;
		}
		static BigInteger v(long x) {return BigInteger.valueOf(x);}
		static BigInteger s(BigInteger a, BigInteger b) {return a.add(b);}
		static BigInteger m(BigInteger a, BigInteger b) {return a.multiply(b);}
		static BigInteger sub(BigInteger a, BigInteger b) {return a.subtract(b);}
		static BigInteger d(BigInteger a, BigInteger b) {return a.divide(b);}
		static boolean pos(BigInteger a) {return a.signum() > 0;}
		static boolean neg(BigInteger a) {return a.signum() < 0;}
	}

}
