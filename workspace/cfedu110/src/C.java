import java.util.*;
import java.io.*;

public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			char[] s = sc.next().toCharArray();
			int n = s.length;
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				if(i % 2 == 0) {
					if(s[i] == '0') s[i] = '1';
					else if(s[i] == '1') s[i] = '0';
				}
			}
			long res = 0;
			int a = 0, b = 0;
			int lastfix = -1;
			while(a < n) {
				while(b < n) {
					if(a > lastfix) {
						if(s[b] != '?') lastfix = b;
						b++;
					}
					else if(s[b] == s[lastfix]) {
						lastfix = b;
						b++;
					}
					else if(s[b] == '?') {
						b++;
					}
					else {
						break;
					}
				}
				res += b - a;
				a++;
			}
			System.out.println(res);
		}	

	}
	
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
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
