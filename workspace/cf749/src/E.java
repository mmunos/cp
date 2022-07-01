import java.util.*;
import java.io.*;
public class E {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		LinkedList<Integer>[] g = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			g[i] = new LinkedList<>();
		}
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			g[u].add(v); g[v].add(u);
		}
		int[] p = new int[n];
		Arrays.fill(p, -1);
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(0);
		p[0] = 0;
		while(!q.isEmpty()) {
			int u = q.removeFirst();
			for(int v: g[u]) {
				if(p[v] < 0) {
					p[v] = u;
					q.add(v);
				}
			}
		}
		gt = new HashMap[n];
		for(int i = 0; i < n; i++) {
			gt[i] = new HashMap<>();
		}
		for(int i = 1; i < n; i++) {
			int u = i, v = p[i];
			gt[u].put(v, 0);
			gt[v].put(u, 0);
		}
		int qs = sc.nextInt();
		LinkedList<Integer>[] qnodes = new LinkedList[qs];
		for(int i = 0; i < qs; i++) {
			qnodes[i] = new LinkedList<>();
			int uq = sc.nextInt()-1;
			int vq = sc.nextInt()-1;
			int[] pp = new int[n];
			Arrays.fill(pp, -1);
			q = new LinkedList<Integer>();
			q.add(uq);
			pp[uq] = uq;
 			while(!q.isEmpty()) {
				int u = q.removeFirst();
				for(int v: gt[u].keySet()) {
					if(pp[v] < 0) {
						pp[v] = u;
						q.add(v);
					}
				}
			}
			while(vq != uq) {
				qnodes[i].addFirst(vq);
				int u = pp[vq];
				int w = gt[u].get(vq);
				gt[u].put(vq, w+1);
				gt[vq].put(u, w+1);
				vq = u;
			}
			qnodes[i].addFirst(vq);
		}
		open = new boolean[n];
		count = new int[n];
		int r = dfs(0, -1);
		if(r == 0) {
			StringBuilder sbres = new StringBuilder();
			for(int i = 0; i < qs; i++) {
				StringBuilder sb = new StringBuilder();
				int cr = 0;
				for(int u: qnodes[i]) {
					sb.append((u+1)+" "); cr++;
				}
				sb.replace(sb.length()-1, sb.length(), "\n");
				sbres.append(cr+"\n");
				sbres.append(sb);
			}
			PrintWriter pw = new PrintWriter(System.out);
			pw.println("YES");
			pw.print(sbres.toString());
			pw.flush();
		}
		else {
			System.out.println("NO");
			System.out.println(r);
		}
	}
	static boolean[] open;
	static int[] count;
	static HashMap<Integer, Integer>[] gt;
	static int dfs(int u, int p) {
		boolean leaf = true;
		for(int v: gt[u].keySet()) {
			if(v != p) {
				leaf = false;
				int w = gt[u].get(v);
				if(w % 2 == 1) {
					if(open[u]) open[u] = false;
					else {
						count[u]++; open[u] = true;
					}
				}
				int a = dfs(v, u);
				count[u] += a;
				if(w % 2 == 1 && open[v]) {
					count[u]--;
				}
			}
		}
		return count[u];
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
