import java.math.*;
public class p137 {

	public static void main(String[] args) {
		long n = 10000000000L;
		for(long i = 0; i <= n; i++) {
			proc(5 * i + 0);
			proc(5 * i + 2);
			proc(5 * i + 4);
		}

	}
	static void proc(long x) {
		if(issq(val(x))) System.out.println(x);
	}
	static BigInteger val(long n) {
		return s(m(v(5), v(n).pow(2)), s(m(v(2),v(n)),v(1)));
	}
	static boolean issq(BigInteger x) {
		BigInteger sqx = x.sqrt();
		return sqx.multiply(sqx).equals(x);
	}
	static boolean issq(long x) {
		long sqx = (long)Math.sqrt(x);
		return sqx * sqx == x;
	}
	
	static BigInteger v(long x) {return BigInteger.valueOf(x);}
	static BigInteger s(BigInteger a, BigInteger b) {return a.add(b);}
	static BigInteger m(BigInteger a, BigInteger b) {return a.multiply(b);}
	static BigInteger sub(BigInteger a, BigInteger b) {return a.subtract(b);}
	static BigInteger d(BigInteger a, BigInteger b) {return a.divide(b);}
	static boolean pos(BigInteger a) {return a.signum() > 0;}
	static boolean neg(BigInteger a) {return a.signum() < 0;}

}
