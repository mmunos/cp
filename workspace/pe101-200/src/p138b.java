import java.math.BigInteger;

public class p138b {
	
	static long[] hs = {17L,
			305L,
			5473L,
			98209L,
			1762289L, 
			31622993L,
			567451585L,
			10182505537L,
			182717648081L,
			3278735159921L,
			58834515230497L,
			1055742538989025L};

	public static void main(String[] args) {
		long res = 0;
		for(long h: hs) res += h;
		System.out.println(res);
		
		BigInteger x = v(1), y = v(0);
		int n = 100;
		for(int iter = 0; iter < n; iter++) {
			BigInteger _x = s(v(-9).multiply(x), s(v(20).multiply(y) , v(8)));
			BigInteger _y = s(v(4).multiply(x), s(v(-9).multiply(y), v(-4)));
			x = _x; y = _y;
			System.out.println(x+" "+y);
		}
	}
	


	static BigInteger v(long x) {return BigInteger.valueOf(x);}
	static BigInteger s(BigInteger a, BigInteger b) {return a.add(b);}
	static BigInteger m(BigInteger a, BigInteger b) {return a.multiply(b);}
	static BigInteger sub(BigInteger a, BigInteger b) {return a.subtract(b);}
	static BigInteger d(BigInteger a, BigInteger b) {return a.divide(b);}
	static boolean pos(BigInteger a) {return a.signum() > 0;}
	static boolean neg(BigInteger a) {return a.signum() < 0;}
	
}
