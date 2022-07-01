import java.math.*;
public class FractionUtils {

	public static void main(String[] args) {

	}
	static class Fraction implements Comparable<Fraction>{
		long a, b;
		public Fraction(long a, long b) {
			long g = gcd(Math.abs(a), Math.abs(b));
			this.a = a / g; this.b = b / g;
			if(b < 0){
				this.a = -this.a; this.b = -this.b;
			}
		}
		public Fraction add(Fraction f) {
			return new Fraction(a*f.b + f.a*b, b*f.b);
		}
		public Fraction sub(Fraction f){
			return new Fraction(a*f.b - f.a*b, b*f.b)
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
