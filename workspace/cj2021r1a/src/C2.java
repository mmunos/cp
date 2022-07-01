import java.util.*;
import java.math.*;
import java.io.*;
public class C2 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 1;
		while(T-->0) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			char[][] ans = new char[n][q];
			int[] corr = new int[n];
			for(int i = 0; i < n; i++) {
				ans[i] = sc.next().toCharArray();
				corr[i] = sc.nextInt();
			}
			HashSet<Integer> masks = new HashSet<>();
			int[] count = new int[q];
			for(int mask = 0; mask < (1 << q); mask++) {
				int[] curr = new int[n];
				for(int i = 0; i < n; i++) {
					curr[i] = count(mask, ans[i]);
				}
				boolean eq = true;
				for(int i = 0; i < n; i++) {
					if(corr[i] != curr[i]) eq = false;
				}
				if(eq) {
					masks.add(mask);
					for(int i = 0; i < q; i++) {
						if((mask & (1 << i)) > 0) count[i]++;
					}
				}
			}
			int tot = masks.size();
			char[] res = new char[q];
			for(int i = 0; i < q; i++) {
				if(count[i] > tot - count[i]) res[i] = 'T';
				else res[i] = 'F';
			}
			int e = 0;
			for(int m: masks) {
				e += count(m, res);
			}
			int g = gcd(tot, e);
			System.out.printf("Case #%d: %s %d/%d\n", caso++, new String(res), e / g, tot / g);
		
		}

	}
	static char[] tores(int mask, int q) {
		char[] res = new char[q];
		for(int i = 0; i < q; i++) {
			if((mask & (1 << i)) > 0) res[i] = 'T';
			else res[i] = 'F';
		}
		return res;
	}
	static int count(int mask, char[] res) {
		int n = res.length;
		int tot = 0;
		for(int i = 0; i < n; i++) {
			if((mask & (1 << i)) > 0 && res[i] == 'T') tot++;
			else if((mask & (1 << i)) == 0 && res[i] == 'F') tot++;
		}
		return tot;
	}
	static int gcd(int a, int b) {
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
