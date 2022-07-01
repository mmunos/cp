import java.util.*;
import java.io.*;
public class E {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] brr = new int[n];
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		while(brr != null) {
			char[] s = new char[n];
			for(int i = 0; i < n; i++) {
				s[i] = (char)(brr[i]+'a');
			}
			String key = Arrays.toString(suff(new String(s)));
			if(!map.containsKey(key)) map.put(key, new ArrayList<>());
			map.get(key).add("\n"+new String(s));
			brr = next(brr, k);
		}
		System.out.println(map.get(Arrays.toString(arr)));
	}
	static int[] suff(String s) {
		int n = s.length();
		Pair[] ps = new Pair[n];
		for(int i = 0; i < n; i++) {
			ps[i] = new Pair(s.substring(i), i);
		}
		Arrays.sort(ps);
		int[] res = new int[n];
		for(int i = 0; i < n; i++) {
			res[i] = ps[i].ind;
		}
		return res;
	}
	static class Pair implements Comparable<Pair>{
		String s; int ind;
		public Pair(String s, int ind) {
			this.s = s; this.ind = ind;
		}
		public int compareTo(Pair p) {
			return s.compareTo(p.s);
		}
		public String toString() {
			return s+" "+ind;
		}
	}
	static int[] next(int[] arr, int m) {
		int n = arr.length;
		int i = n-1;
		for(; i >= 0; i--) {
			arr[i]++;
			if(arr[i] < m) break;
			else arr[i] = 0;
		}
		if(i < 0) return null;
		return arr;
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
