import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			long w = sc.nextLong();
			long[] arr = new long[n];
			Multiset ms = new Multiset();
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
				ms.add(arr[i]);
			}
			int res = 1;
			long curr = w;
			while(!ms.ms.isEmpty()) {
				Long x = ms.ms.floorKey(curr);
				if(x == null) {
					res++;
					curr = w;
				}
				else {
					ms.remove(x);
					curr -= x;
				}
			}
			sb.append(res+"\n");
		}	
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static class Multiset{
		TreeMap<Long, Integer> ms;
		public Multiset() {
			ms = new TreeMap<>();
		}
		public void add(long x) {
			if(ms.containsKey(x)) ms.put(x, ms.get(x)+1);
			else ms.put(x, 1);
		}
		public void remove(long x) {
			ms.put(x, ms.get(x)-1);
			if(ms.get(x) == 0) ms.remove(x);
		}
		public String toString() {
			return ms.toString();
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
