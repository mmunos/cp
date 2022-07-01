import java.util.*;
import java.io.*;
public class E { //nope

	static int N = 9;
	static  HashMap<String, HashSet<Pair>>[] map = new HashMap[N+1];
	public static void main(String[] args) {
//		for(int n = 1; n <= N; n++) {
//			map[n] = new HashMap<>();
//			for(int k = 0; k < n; k++) {
//				char[] s = shift(n, k);
//				String ss = new String(s);
//				if(!map[n].containsKey(ss)) map[n].put(ss, new HashSet<>());
//				map[n].get(ss).add(new Pair(k, 0));
//				genswaps(n, k, s, 1);
//			}
//			for(String s: map[n].keySet()) {
//				if(map[n].get(s).size() > 1) {
//					System.out.println(s+" "+map[n].get(s));
//				}
//			}
//		}
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sbres = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt()-1;
			}
			int[] shs = new int[n];
			long sum = 0;
			for(int i = 0; i < n; i++) {
				shs[i] = (i-arr[i]+n)%n;
				sum += shs[i];
			}
			System.out.println(Arrays.toString(shs));
			int[] occ = new int[n];
			for(int i = 0; i < n; i++) {
				occ[shs[i]]++;
			}
			StringBuilder sb = new StringBuilder();
			int c = 0;
			for(int i = 0; i < n; i++) {
				if(occ[i] >= n - 2*m && sum % n == 0) {
					sb.append(" "+i); c++;
				}
			}
			sbres.append(c+"");
			sbres.append(sb);
			sbres.append("\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sbres.toString().trim());
		pw.flush();
	}
	static void genswaps(int n, int k, char[] s, int iter) {
		if(iter > n/3) return;
		for(int a = 0; a < n; a++) {
			for(int b = a+1; b < n; b++) {
				char[] s1 = swap(s, a, b);
				String ss1 = new String(s1);
				if(!map[n].containsKey(ss1)) map[n].put(ss1, new HashSet<>());
				map[n].get(ss1).add(new Pair(k, iter));
				genswaps(n, k, s1, iter+1);
			}
		}
	}
	static char[] shift(int n, int k) {
		char[] res = new char[n];
		for(int i = 0; i < n; i++) {
			res[(i+k)%n] = (char)(i+1+'0');
		}
		return res;
	}
	static char[] swap(char[] s, int a, int b) {
		char[] res = s.clone();
		res[a] = s[b]; res[b] = s[a];
		return res;
	}
	static class Pair{
		int a, b;
		public Pair(int a, int b) {
			this.a = a; this.b = b;
		}
		@Override
		public int hashCode() {
			return a << 16 + b;
		}
		@Override
		public boolean equals(Object o) {
			Pair p = (Pair)o;
			return a == p.a && b == p.b;
		}
		public String toString() {
			return a+" "+b;
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
