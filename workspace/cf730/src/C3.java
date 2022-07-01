import java.util.*;
import java.io.*;
import java.math.*;
public class C3 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			BigDecimal a = new BigDecimal(sc.next());
			BigDecimal b = new BigDecimal(sc.next());
			BigDecimal c = new BigDecimal(sc.next());
			BigDecimal d = new BigDecimal(sc.next());
			BigDecimal res = exp(a, b, c, d);
			System.out.println(res);
		}
		
	}
	static BigDecimal two = new BigDecimal(2);
	static BigDecimal mone = new BigDecimal(-1);
	static BigDecimal one = new BigDecimal(1);
	static BigDecimal exp(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d) {
		BigDecimal res = new BigDecimal(0);
		res = res.add(c); //finish now
		if(a.signum() < 0 && b.signum() < 0) {
			;
		}
		else if(b.signum() < 0) {
			if(d.compareTo(a) < 0) {
				res = a.multiply(exp(a.subtract(d), mone, c.add(d), d).add(one)).add(res);
			}
			else {
				res = a.multiply(exp(mone, mone, c.add(a), d).add(one)).add(res);
			}
		}
		else if(a.signum() < 0) {
			if(d.compareTo(b) < 0) {
				res = b.multiply(exp(mone, b.subtract(d), c.add(d), d).add(one)).add(res);
			}
			else {
				res = b.multiply(exp(mone, mone, c.add(b), d).add(one)).add(res);
			}
		}
		else {
			if(d.compareTo(a) < 0) {
				res = a.multiply(exp(a.subtract(d), b.add(d.divide(two)), c.add(d.divide(two)), d).add(one)).add(res);
			}
			else {
				res = a.multiply(exp(mone, b.add(a.divide(two)), c.add(a.divide(two)), d).add(one)).add(res);
			}
			if(d.compareTo(b) < 0) {
				res = b.multiply(exp(a.add(d.divide(two)), b.subtract(d), c.add(d.divide(two)), d).add(one)).add(res);
			}
			else {
				res = b.multiply(exp(a.add(b.divide(two)), mone, c.add(b.divide(two)), d).add(one)).add(res);
			}
		}
		return res;
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
