import java.util.*;
import java.math.*;
import java.io.*;
public class B {

	static int[] ps = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499};
	static int[] sieve;
	static int[] pos;
	static int psn;
	public static void main(String[] args) {
		int N = 50000;
		sieve = new int[N+1];  //is prime iff sieve[i] == i
		int sqN = (int)Math.sqrt(N);
		for(int i = 2; i <= N; i++) {
			if(sieve[i] == 0) {
				sieve[i] = i;
				if(i > sqN) continue;
				for(int j = i*i; j <= N; j += i) {
					sieve[j] = i;
				}
			}
		}
		psn = ps.length;
		pos = new int[500];
		for(int i = 0; i < psn; i++) {
			pos[ps[i]] = i;
		}
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 1;
		while(T-->0) {
			int n = sc.nextInt();
			int[] c = new int[psn];
			int tot = 0;
			for(int i = 0; i < n; i++) {
				int p = sc.nextInt();
				int k = sc.nextInt();
				c[pos[p]] = k;
				tot += k * p;
			}
			int res = tot;
			while(res > 0) {
				if(check(res, tot, c)) {
					break;
				}
				else res--;
			}
			System.out.printf("Case #%d: %d\n", caso++, res);
		}
	}
	static boolean check(int val, int tot, int[] c) {
		int[] d = new int[psn];
		int aux = val;
		while(aux > 1) {
			int p = sieve[aux];
			if(p >= 500) return false;
			else d[pos[p]]++;
			aux /= p;
		}
		for(int i = 0; i < psn; i++) {
			if(d[i] > c[i]) return false;
			else tot -= ps[i] * d[i];
		}
		return val == tot;
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
