import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sbres = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			LinkedList<Integer>[] pos = new LinkedList[n+1];
			for(int i = 0; i <= n; i++) {
				pos[i] = new LinkedList<>();
			}
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt();
				arr[i] = a;
				pos[a].add(i);
			}
			StringBuilder sb = new StringBuilder();
			int count = 0;
			int ind = 0;
			while(true) {
				int v = -1;
				int p = 0;
				for(int i = 0; i <= n; i++) {
					if(pos[i].isEmpty()) {
						v = i; break;
					}
					else {
						int x = pos[i].peekFirst();
						p = Math.max(p, x);
					}
				}
				if(v == 0) {
					p = ind;
				}
				while(ind <= p) {
					pos[arr[ind]].removeFirst();
					ind++;
				}
				sb.append(v+" ");
				count++;
				if(p == n-1) break;
			}
			sb.replace(sb.length()-1, sb.length(), "\n");
			sbres.append(count+"\n");
			sbres.append(sb);
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sbres.toString().trim());
		pw.flush();
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
