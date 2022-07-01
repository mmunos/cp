import java.util.*;
import java.io.*;
public class A2 { //AC

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
	static long nano = 1000000000L;
	static long k = 3600L*12L*nano;
	static long[] check(long h, long m, long s) {
		long d = (s - h + k) % k;
		for(long _rm = 0; _rm < 60*12; _rm++) {
			long dplus = d + _rm * k;
			if(dplus % 719L != 0) continue;
			long tick = dplus / 719L;
			long rph = tick % k;
			long rpm = tick * 12 % k;
			long rps = tick * 720 % k;
			long ds = (rps - s + k) % k;
			long dm = (rpm - m + k) % k;
			long dh = (rph - h + k) % k;
			if(ds == dm && dm == dh) {
				return new long[] {tick / nano / 60 / 60, tick / nano / 60 % 60, tick / nano % 60, tick % nano};
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
