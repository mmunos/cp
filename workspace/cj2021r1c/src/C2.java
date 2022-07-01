import java.util.*;
import java.io.*;
public class C2 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 1;
		while(T-->0) {
			String s = sc.next();
			String t = sc.next();
			StringBuilder sbinv = new StringBuilder();
			for(int i = 0; i < s.length(); i++) {
				sbinv.append(s.charAt(i));
			}
			while(sbinv.length() > 1 && sbinv.charAt(0) == '0') sbinv.deleteCharAt(0);
			String sinv = sbinv.toString();
			int res = Integer.MAX_VALUE;
			int a = cost(t);
			int b = avail(s);
			if(b >= a) {
				res = t.length() + b;
			}
			res = Math.min(res, calc(s, t));
			res = Math.min(res, calc(sinv, t));
			if(res < 0) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", caso++); continue;
			}
			else {
				System.out.printf("Case #%d: %d\n", caso++, res); continue;
			}
		}

	}
	static int calc(String s, String t) {
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1' && (i == 0 || s.charAt(i-1) == '0')) {
				String reg = s.substring(i);
				if(t.length() >= reg.length() && reg.equals(t.substring(0, reg.length()))) {
					int a = cost(t.substring(reg.length()));
					int b = avail(s.substring(0, i));
					if(b >= a) {
						int p = t.length() - reg.length() + b;
						res = Math.min(p, res);
					}
				}
			}
		}
		return res;
	}
	static int cost(String str) {
		char[] s = str.toCharArray();
		int res = 0;
		for (int i = 0; i < s.length-1; i++) {
			if(s[i] == '1' && (i == 0 || s[i-1] == '0')) res += 2;
		}
		return res;
	}
	static int avail(String str) {
		char[] s = str.toCharArray();
		int res = 1;
		for (int i = 0; i < s.length-1; i++) {
			if(s[i] != s[i+1]) res++;
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
