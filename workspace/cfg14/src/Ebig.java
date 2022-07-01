import java.util.*;
import java.math.*;
import java.io.*;
public class Ebig {

	static int N = 400;
	static long mod;
	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
//		int n = sc.nextInt();
//		mod = sc.nextLong();
		c = new BigInteger[N+1][N+1];
		c[0][0] = BigInteger.ONE;
		for(int i = 0; i <= N; i++){
			c[i][0] = BigInteger.ONE;
			c[i][i] = BigInteger.ONE;
			for(int j = 1; j < i; j++){
				c[i][j] = c[i-1][j].add(c[i-1][j-1]);
			}
		}
		dpcl = new BigInteger[N+1][N+1];
		dpop = new BigInteger[N+1][N+1];
		PrintWriter pw = new PrintWriter(new File("what.txt"));
		pw.flush();
		for(int i = 1; i < 401; i++) {
			pw.println(i + " "+calc(i)); pw.flush();
		}
	}
	static BigInteger calc(int n) {
		BigInteger res = BigInteger.ZERO;
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= n-1; j++){
				for(int a = 0; a <= j; a++) {
					BigInteger leftv = dpop(i, a);
					BigInteger rightv = dpop(n-i-1, j-a);
					BigInteger curr = leftv.multiply(rightv);
					BigInteger fac = c[j][a];
					BigInteger v = curr.multiply(fac);
					res = res.add(v);
				}
			}
		}
		return res;
	}
	static BigInteger[][] c, dpcl, dpop;
	static BigInteger dpcl(int n, int k) {
		if(dpcl[n][k]!= null) return dpcl[n][k];
		if(n == 0 || n == 1) {
			if(k == 0) {
				return dpcl[n][k] = BigInteger.ONE;
			}
			else {
				return dpcl[n][k] = BigInteger.ZERO;
			}
		}
		if(k == 0) { // n > 1
			return dpcl[n][k] = BigInteger.ZERO;
		}
		BigInteger res = BigInteger.ZERO;
		for(int i = 0; i < n; i++){
			for(int a = 0; a <= k-1; a++) {
				BigInteger leftv = dpcl(i, a);
				BigInteger rightv = dpcl(n-i-1, k-1-a);
				BigInteger curr = leftv.multiply(rightv);
				BigInteger fac = c[k-1][a];
				BigInteger v = curr.multiply(fac);
				res = res.add(v);
			}
		}
		return dpcl[n][k] = res;
	}
	static BigInteger dpop(int n, int k) {
		if(dpop[n][k] != null) return dpop[n][k];
		if(n == 0) {
			if(k == 0) {
				return dpop[n][k] = BigInteger.ONE;
			}
			else {
				return dpop[n][k] = BigInteger.ZERO;
			}
		}
		if(k == 0) { // n > 0
			return dpop[n][k] = BigInteger.ZERO;
		}
		BigInteger res = BigInteger.ZERO;
		for(int i = 0; i < n; i++){
			for(int a = 0; a <= k-1; a++) {
				BigInteger leftv = dpcl(i, a);
				BigInteger rightv = dpop(n-i-1, k-1-a);
				BigInteger curr = leftv.multiply(rightv);
				BigInteger fac = c[k-1][a];
				BigInteger v = curr.multiply(fac);
				res = res.add(v);
			}
		}
		return dpop[n][k] = res;
	}
	static class Pair implements Comparable<Pair>{
		int i; long w;
		public Pair(int i, long w) {
			this.i = i; this.w = w;
		}
		public String toString() {
			return i+" "+w;
		}
		@Override
		public int compareTo(Pair p) {
			return Long.compare(w, p.w);
		}
	}
	
	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
