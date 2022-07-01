import java.util.*;
import java.math.*;
import java.io.*;
public class C {

	static BigInteger nine = BigInteger.valueOf(9);
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 1;
		while(T-->0) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			if(n == 1) {
				char[] s = sc.next().toCharArray();
				int a = sc.nextInt();
				if(n - a > a) {
					for(int i = 0; i < q; i++) {
						if(s[i] == 'T') s[i] = 'F';
						else s[i] = 'T';
					}
					a = n - a;
				}
				System.out.printf("Case #%d: %s %d/1\n", caso++, new String(s), a);
			}
			else {
				char[] s = sc.next().toCharArray();
				int x = sc.nextInt();
				char[] t = sc.next().toCharArray();
				int y = sc.nextInt();
				int N = (1 << q);
				int[] count = new int[q];
				int tot = 0;
				HashSet<Integer> masks = new HashSet<>();
				for(int mask = 0; mask < N; mask++) {
					int a = count(mask, s);
					int b = count(mask, t);
					if(a == x && b == y) {
						tot++;
						for(int i = 0; i < q; i++) {
							if((mask & (1 << i)) > 0) count[i]++;
						}
						masks.add(mask);
					}
				}
				for(int mask: masks) {
					System.out.println(tores(mask, q));
				}
				System.out.println(Arrays.toString(count));
				char[] res = new char[q];
				for(int i = 0; i < q; i++) {
					if(count[i] > tot - count[i]) res[i] = 'T';
					else res[i] = 'F';
				}
				int expt = 0;
				for(int mask: masks) {
					expt += count(mask, res);
				}
				int g = gcd(tot, expt);
				System.out.printf("Case #%d: %s %d/%d\n", caso++, new String(res), expt / g, tot / g);
			}
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
