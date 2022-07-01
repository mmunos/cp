import java.math.*;
import java.util.*;
public class p128c {
	
	public static void main(String...strings) {
		int n = 70000;
		BigInteger[][] pivs = new BigInteger[n][6];
		for(int i = 0; i < 6; i++) {
			pivs[0][i] = v(1);
		}
		BigInteger u = v(2);
		for(int i = 1; i < n; i++) {
			for(int r = 0; r < 6; r++) {
				pivs[i][r] = u;
				u = s(u, v(i));
			}
		}
		ArrayList<BigInteger> list = new ArrayList<>();
		list.add(v(1));
		for(int i = 1; i < n-2; i++) {
			BigInteger v0 = pivs[i][0];
			ArrayList<BigInteger> edges = new ArrayList<>();
			edges.add(pivs[i-1][0]);
			edges.add(sub(pivs[i+1][0],v(1)));
			edges.add(sub(pivs[i+2][0],v(1)));
			edges.add(pivs[i+1][0]);
			edges.add(s(pivs[i+1][0],v(1)));
			if(check(v0, edges)) list.add(v0);
//			for(int r = 1; r < 6; r++) {
//				BigInteger v = pivs[i][r];
//				edges = new ArrayList<>();
//				edges.add(pivs[i-1][r]);
//				edges.add(sub(pivs[i+1][r],v(1)));
//				edges.add(pivs[i+1][r]);
//				edges.add(s(pivs[i+1][r],v(1)));
//				if(check(v, edges)) list.add(v);
//			}
			BigInteger vf = sub(pivs[i+1][0],v(1));
			edges = new ArrayList<>();
			edges.add(sub(pivs[i][0],v(1)));
			edges.add(pivs[i-1][0]);
			edges.add(pivs[i][0]);
			edges.add(sub(pivs[i+2][0],v(2)));
			edges.add(sub(pivs[i+2][0],v(1)));
			if(check(vf, edges)) list.add(vf);
		}
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(9));
		System.out.println(list.get(1999));
	}
	static boolean check(BigInteger u, ArrayList<BigInteger> edges) {
		int c = 0;
		for(BigInteger e: edges) {
			if(sub(e,u).abs().isProbablePrime(100)) c++;
		}
		return c == 3;
	}
	static boolean isPrime(long x) {
		if(x == 1) return false;
		for(long d = 2; d*d <= x; d++) {
			if(x % d == 0) return false;
		}
		return true;
	}
	
	static BigInteger v(long x) {return BigInteger.valueOf(x);}
	static BigInteger s(BigInteger a, BigInteger b) {return a.add(b);}
	static BigInteger m(BigInteger a, BigInteger b) {return a.multiply(b);}
	static BigInteger sub(BigInteger a, BigInteger b) {return a.subtract(b);}
	static BigInteger d(BigInteger a, BigInteger b) {return a.divide(b);}
	static boolean pos(BigInteger a) {return a.signum() > 0;}
	static boolean neg(BigInteger a) {return a.signum() < 0;}

}
