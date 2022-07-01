import java.util.*;
import java.io.*;
public class Dslow {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		String s = sc.next();
		HashMap<String, Integer> d = new HashMap<>();
		d.put(s, 0);
		LinkedList<String> q = new LinkedList<String>();
		q.add(s);
		int maxd = 0;
		while(!q.isEmpty()) {
			String u = q.removeFirst();
			for(int i = 0; i < u.length()-1; i++) {
				String v = next(u, i);
				if(!d.containsKey(v)) {
					d.put(v, d.get(u)+1);
					q.add(v);
					if(d.get(u)+1 > maxd) {
						maxd = d.get(u)+1;
					}
				}
			}
		}
		for(String t: d.keySet()) {
			if(d.get(t) == maxd) System.out.println(t);
		}
	}
	static String next(String s, int i) {
		StringBuilder sb = new StringBuilder(s);
		char c = sb.charAt(i);
		sb.deleteCharAt(i);
		sb.insert(i+1, c);
		return sb.toString();
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
