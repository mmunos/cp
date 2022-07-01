import java.util.*;
import java.io.*;
import java.math.*;
public class C2 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			a = sc.nextDouble();
			b = sc.nextDouble();
			c = sc.nextDouble();
			d = sc.nextDouble();
			double res = c;
			for(int size = 1; size < 26; size++) {
				int m = 1 << size;
				for(int mask = 0; mask < m; mask++) {
					res += (size+1)*process(mask, size);
				}
			}
			System.out.println(res);
		}
		
	}
	static double a, b, c, d;
	static double process(int mask, int size) {
		BigDecimal bigd = new BigDecimal(d);
		BigDecimal curra = new BigDecimal(a);
		boolean aalive = true;
		BigDecimal currb = new BigDecimal(b);
		boolean balive = true;
		BigDecimal currc = new BigDecimal(c);
		BigDecimal res = new BigDecimal(1);
		for(int i = 0; i < size; i++) {
			if((mask & (1 << i)) > 0) {
				if(!aalive) return 0;
				res = res.multiply(curra);
				if(currb < 0) {
					if(curra > d) {
						curra -= d;
						currc += d;
					}
					else {
						currc += curra;
						curra = -1;					
					}
				}
				else {
					if(curra > d) {
						curra -= d;
						currb += d/2;
						currc += d/2;
					}
					else {
						currb += curra/2;
						currc += curra/2;
						curra = -1;					
					}
				}
			}
			else {
				if(!balive) return 0;
				res = res.multiply(currb);
				if(!aalive) {
					if(currb > d) {
						currb -= d;
						currb += d;
					}
					else {
						currc += currb;
						currb = -1;					
					}
				}
				else {
					if(currb > d) {
						currb -= d;
						curra += d/2;
						currc += d/2;
					}
					else {
						curra += currb/2;
						currc += currb/2;
						currb = -1;
					}
				}
			}
		}
		return res * currc;
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
