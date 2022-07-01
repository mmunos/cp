import java.util.*;
import java.io.*;
import java.math.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			Fraction[] fs = new Fraction[4];
			for(int i = 0; i < 4; i++) {
				String s = sc.next();
				int v = getdecs(s);
				int d = (int)Math.pow(10, s.length()-2);
				fs[i] = new Fraction(v, d);
			}
			Fraction res = exp(fs[0], fs[1], fs[2], fs[3]);
			System.out.println(res.a*1.0/res.b);
		}
		
	}
	static int getdecs(String s) {
		return Integer.parseInt(s.substring(2));
	}
	static Fraction two = new Fraction(2, 1);
	static Fraction mone = new Fraction(-1, 1);
	static Fraction one = new Fraction(1, 1);
	static Fraction exp(Fraction a, Fraction b, Fraction c, Fraction d) {
		Fraction res = new Fraction(0, 1);
		res = res.add(c); //finish now
		if(a.fneg() && b.fneg()) {
			;
		}
		else if(b.fneg()) {
			if(d.compareTo(a) < 0) {
				res = a.mult(exp(a.fsub(d), mone, c.add(d), d).add(one)).add(res);
			}
			else {
				res = a.mult(exp(mone, mone, c.add(a), d).add(one)).add(res);
			}
		}
		else if(a.fneg()) {
			if(d.compareTo(b) < 0) {
				res = b.mult(exp(mone, b.fsub(d), c.add(d), d).add(one)).add(res);
			}
			else {
				res = b.mult(exp(mone, mone, c.add(b), d).add(one)).add(res);
			}
		}
		else {
			if(d.compareTo(a) < 0) {
				res = a.mult(exp(a.fsub(d), b.add(d.div(two)), c.add(d.div(two)), d).add(one)).add(res);
			}
			else {
				res = a.mult(exp(mone, b.add(a.div(two)), c.add(a.div(two)), d).add(one)).add(res);
			}
			if(d.compareTo(b) < 0) {
				res = b.mult(exp(a.add(d.div(two)), b.fsub(d), c.add(d.div(two)), d).add(one)).add(res);
			}
			else {
				res = b.mult(exp(a.add(b.div(two)), mone, c.add(b.div(two)), d).add(one)).add(res);
			}
		}
		return res;
	}

	static long max = 1000000000;
	
	static class Fraction implements Comparable<Fraction>{
		long a, b;
		public Fraction(long a, long b) {
			long g = gcd(Math.abs(a), Math.abs(b));
			if(g > 0) {
				this.a = a / g; this.b = b / g;
			}
			while(a+b>max) {
				double f = a*1.0/b;
				a = (long)(f*max/10); b = max/10;
			}
		}
		public Fraction add(Fraction f) {
			return new Fraction(a*f.b + f.a*b, b*f.b);
		}
		public Fraction fsub(Fraction f){
			return new Fraction(a*f.b - f.a*b, b*f.b);
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
		public boolean fneg() {
			return a < 0;
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
