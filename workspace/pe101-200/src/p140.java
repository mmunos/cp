import java.math.BigInteger;
import java.util.*;
public class p140 {
	
	static long[][] xy2 = { {-1,0},
			{-7,2},
			{-5,-4},
			{7,2},
			{5,-4},
			{1,0},
			{-14,5},
			{-2,-3},
			{14,5},
			{2,-3} };

	public static void main(String[] args) {
		TreeSet<BigInteger> ns = new TreeSet<>();
		for(long[] xy: xy2) {
			BigInteger x = v(xy[0]), y = v(xy[1]);
			int n = 30;
			for(int iter = 0; iter < n; iter++) {
				if(y.signum()>0) ns.add(y);
				BigInteger _x = s(v(-9).multiply(x), s(v(20).multiply(y) , v(28)));
				BigInteger _y = s(v(4).multiply(x), s(v(-9).multiply(y), v(-14)));
				x = _x; y = _y;
			}
		}
		System.out.println(ns);
		int t = 30;
		long tot = 0;
		while(t-->0) {
			tot += ns.pollFirst().longValue();
		}
		System.out.println(tot);
	}

	static BigInteger v(long x) {return BigInteger.valueOf(x);}
	static BigInteger s(BigInteger a, BigInteger b) {return a.add(b);}
	static BigInteger m(BigInteger a, BigInteger b) {return a.multiply(b);}
	static BigInteger sub(BigInteger a, BigInteger b) {return a.subtract(b);}
	static BigInteger d(BigInteger a, BigInteger b) {return a.divide(b);}
	static boolean pos(BigInteger a) {return a.signum() > 0;}
	static boolean neg(BigInteger a) {return a.signum() < 0;}
}
