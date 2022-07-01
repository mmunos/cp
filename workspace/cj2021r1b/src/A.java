import java.util.*;
import java.io.*;
public class A {

	static int[][] cs = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 1;
		while(T-->0) {
			long[] ps = new long[3];
			for(int i = 0; i < 3; i++) {
				ps[i] = sc.nextLong();
			}
			for(int i = 0; i < 6; i++) {
				long[] res = check(ps[cs[i][0]], ps[cs[i][1]], ps[cs[i][2]]);
				if(res != null) {
					System.out.printf("Case #%d: %d %d %d %d\n", caso++, res[0], res[1], res[2], res[3]);
					break;
				}
			}
		}
		
	}
	static long k = 360L*12L*10000000000L;
	static long nano = 1000000000L;
	static long[] check(long h, long m, long s) {
		for(int i = 0; i < 12; i++) {
			long madj = m + k*i;
			long d = madj - h;
			if(d < 0) d += k;
			if(d % 11L != 0) continue;
			long ms = d / 11L;
			if(ms/nano/60/60 != i) continue;
			long adj = (ms - h) % k;
			long sadj = ((s + adj)%k+k) % k;
			long msang = ms * 720L % k; 
			if(sadj == msang) {
				long[] res = {i, ms/nano/60%60, ms/nano % 60, ms % nano};
				return res;
			}
		}
		return null;
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
