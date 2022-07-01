import java.util.*;
import java.math.*;

public class p104b {

	static long mod = 1000000000;
	public static void main(String...strings) {
		int n = 10000000;
		long[] fib = new long[n];
		fib[1] = 1; fib[2] = 1;
		for(int i = 3; i < n; i++) {
			fib[i] = (fib[i-1] + fib[i-2]) % mod;
			if(check(fib[i])) {
				System.out.println("yay "+i);
				BigInteger val = fib(i);
				if(check(val)) {
					System.out.println(i);
					System.out.println("this is it "+i);
				}
			}
		}
	}
	static BigInteger fib(int n) {
		long[][] init = {{0,1},{1,1}};
		Matrix mat = new Matrix(init);
		Matrix mp = pow(mat, n);
		return mp.mat[0][1];
	}
	static BigInteger v(long x) {return BigInteger.valueOf(x);}
	static BigInteger s(BigInteger a, BigInteger b) {return a.add(b);}
	static BigInteger m(BigInteger a, BigInteger b) {return a.multiply(b);}
	static BigInteger sub(BigInteger a, BigInteger b) {return a.subtract(b);}
	static BigInteger d(BigInteger a, BigInteger b) {return a.divide(b);}
	static boolean pos(BigInteger a) {return a.signum() > 0;}
	static boolean neg(BigInteger a) {return a.signum() < 0;}
	
	
	static Matrix pow(Matrix m, long exp) {
		Matrix res = new Matrix(m.n);
		Matrix mapow = m;
		while(exp > 0) {
			if((exp & 1L) == 1) {
				res = res.mult(mapow);
			}
			mapow = mapow.mult(mapow);
			exp >>= 1;
		}
		return res;
	}
	
	static class Matrix{
		BigInteger[][] mat; int n;
		public Matrix(long[][] mat) {
			n = mat.length;
			this.mat = new BigInteger[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					this.mat[i][j] = v(mat[i][j]);
				}
			}
		}
		public Matrix(BigInteger[][] mat) {
			n = mat.length;
			this.mat = mat;
		}
		public Matrix(int n) {
			mat = new BigInteger[n][n];
			this.n = n;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(i == j) mat[i][j] = v(1);
					else mat[i][j] = v(0);
				}
			}
		}
		Matrix mult(Matrix m) {
			BigInteger[][] res = new BigInteger[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					BigInteger val = BigInteger.ZERO;
					for(int k = 0; k < n; k++) {
						val = s(val, m(mat[i][k],m.mat[k][j]));
					}
					res[i][j] = val;
				}
			}
			return new Matrix(res);
		}
		public String toString(){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++) {
				sb.append(Arrays.toString(mat[i])+"\n");
			}
			return sb.toString();
		}
	}

	static boolean check(long x) {
		boolean[] seen = new boolean[10];
		while(x > 0) {
			if(x % 10 == 0) return false;
			if(seen[(int)(x % 10)]) return false;
			else seen[(int)(x % 10)] = true;
			x /= 10;
		}
		return true;
	}
	
	static boolean check(BigInteger x) {
		char[] s = x.toString().toCharArray();
		if(s.length < 9) return false;
		boolean[] seen = new boolean[10];
		for(int i = 0; i < 9; i++) {
			if(s[i] == '0') return false;
			if(seen[s[i]-'0']) return false;
			seen[s[i]-'0'] = true;
		}
		return true;
	}

}
