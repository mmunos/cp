import java.math.*;
public class p137b {

	public static void main(String[] args) {
		long n = 10000000000L;
		for(long _b = 0; _b <= n; _b++) {
			checkb(5*_b + 1);
		}

	}
	static void checkb(long b) {
		BigInteger a2 = s(v(b).pow(2),v(4)).divide(v(5));
		if(issq(a2)) {
			System.out.println((b - 1) / 5);
		}
	}
	static boolean issq(BigInteger x) {
		BigInteger sqx = x.sqrt();
		return sqx.pow(2).equals(x);
	}
	

	static BigInteger v(long x) {return BigInteger.valueOf(x);}
	static BigInteger s(BigInteger a, BigInteger b) {return a.add(b);}
	static BigInteger m(BigInteger a, BigInteger b) {return a.multiply(b);}
	static BigInteger sub(BigInteger a, BigInteger b) {return a.subtract(b);}
	static BigInteger d(BigInteger a, BigInteger b) {return a.divide(b);}
	static boolean pos(BigInteger a) {return a.signum() > 0;}
	static boolean neg(BigInteger a) {return a.signum() < 0;}

}
