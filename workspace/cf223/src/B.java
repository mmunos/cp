import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		Multiset ms = new Multiset();
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			ms.add(a);
		}
		LinkedList<Long> res = new LinkedList<>();
		long maxa = ms.map.lastKey();
		res.add(maxa);
		ms.map.remove(maxa);
		while(!ms.isEmpty()) {
			long a = ms.map.lastKey();
			if(ms.count(a) == 1) {
				res.addLast(a);
			}
			else {
				res.addLast(a);
				res.addFirst(a);
			}
			ms.map.remove(a);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(res.size()+"\n");
		for(long a: res) {
			sb.append(a+" ");
		}
		sb.replace(sb.length()-1, sb.length(), "\n");
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static class Multiset{
		TreeMap<Long, Integer> map;
		public Multiset() {
			map = new TreeMap<>();
		}
		public void add(long a) {
			if(!map.containsKey(a)) map.put(a, 1);
			else map.put(a, map.get(a)+1);
		}
		public void remove(long a) {
			map.put(a, map.get(a)-1);
			if(map.get(a) == 0) map.remove(a);
		}
		public boolean contains(long a) {
			return map.containsKey(a);
		}
		public int count(long a) {
			if(!map.containsKey(a)) return 0;
			else return map.get(a);
		}
		public boolean isEmpty() {
			return map.isEmpty();
		}
		public boolean equals(Multiset ms) {
			for(long k: map.keySet()) {
				if(count(k) != ms.count(k)) return false;
			}
			return true;
		}
		public String toString() {
			return map.toString();
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
