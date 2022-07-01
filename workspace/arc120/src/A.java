import java.util.*;

import java.io.*;
import java.math.BigInteger;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		Longg[] arr = new Longg[n];
		for(int i = 0; i < n; i++) {
			arr[i] = v(sc.nextLong());
		}
		Longg[] acc = new Longg[n];
		for(int i = 0; i < n; i++) {
			acc[i] = arr[i];
			if(i > 0) acc[i] = acc[i].s(acc[i-1]);
		}
		Longg[] accc = new Longg[n];
		for(int i = 0; i < n; i++) {
			accc[i] = acc[i];
			if(i > 0) accc[i] = accc[i].s(accc[i-1]);
		}
		Longg[] max = new Longg[n];
		for(int i = 0; i < n; i++) {
			max[i] = arr[i];
			if(i > 0) max[i] = max[i].max(arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			Longg v = max[i].m(v(i+1)).s(accc[i]);
			sb.append(v+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	
	static Longg v(long x) { return new Longg(x);}
    static Longg v(String s) { return new Longg(s);}
    static Longg v(BigInteger b) { return new Longg(b);}
    static class Longg implements Comparable<Longg>{
    	BigInteger val;
    	public Longg(long x) {
    		val = BigInteger.valueOf(x);
    	}
    	public Longg(String s) {
    		val = new BigInteger(s);
    	}
    	public Longg(BigInteger b) {
    		val = b;
    	}
    	public boolean eq(Longg l) {
    		return val.equals(l.val);
    	}
    	public Longg s(Longg l) {
    		return new Longg(val.add(l.val));
    	}
    	public Longg sub(Longg l) {
    		return new Longg(val.subtract(l.val));
    	}
    	public Longg m(Longg l) {
    		return new Longg(val.multiply(l.val));
    	}
    	public Longg d(Longg l) {
    		return new Longg(val.divide(l.val));
    	}
    	public Longg mod(Longg l) {
    		return new Longg(val.mod(l.val));
    	}
    	public Longg gcd(Longg l) {
    		return new Longg(val.gcd(l.val));
    	}
    	public Longg max(Longg l) {
    		return new Longg(val.max(l.val));
    	}
    	public boolean isprime() {
    		return val.isProbablePrime(20);
    	}
    	public String toString() {
    		return val.toString();
    	}
    	@Override
    	public int compareTo(Longg l) {
    		return val.compareTo(l.val);
    	}
    	@Override
    	public int hashCode() {
    		return val.hashCode();
    	}
    	@Override
    	public boolean equals(Object o) {
    		return val.equals(((Longg)o).val);
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
