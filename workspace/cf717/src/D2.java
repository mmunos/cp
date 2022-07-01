import java.util.*;
import java.io.*;
public class D2 {

	public static void main(String[] args) {
		int N = 100000;
		int[] sieve = new int[N+1];  //is prime iff sieve[i] == i
		int sqN = (int)Math.sqrt(N);
		for(int i = 2; i <= N; i++) {
			if(sieve[i] == 0) {
				sieve[i] = i;
				if(i > sqN) continue;
				for(int j = i*i; j <= N; j += i) {
					sieve[j] = i;
				}
			}
		}
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] ps = new int[N];
		Arrays.fill(ps, n);
		int[] next = new int[n];
		Arrays.fill(next, n);
		for(int i = n-1; i >= 0; i--) {
			int a = arr[i];
			while(a > 1) {
				int p = sieve[a];
				next[i] = Math.min(next[i], ps[p]);
				ps[p] = i; 
				while(a % p == 0) a /= p;
			}
		}
		Vertex[] vs = new Vertex[n+1];
		int[] c = new int[n+1];
		vs[n] = PST.build(c, 0, n);
		int minnext = n;
		for(int i = n-1; i >= 0; i--) {
			minnext = Math.min(minnext, next[i]);
			vs[i] = PST.update(vs[minnext], 0, n, i, 1);
		}
		StringBuilder sb = new StringBuilder();
		while(q-- > 0) {
			int L = sc.nextInt()-1;
			int R = sc.nextInt()-1;
			int r = PST.get_sum(vs[L], 0, n, L, R);
			sb.append(r+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static int globid = 0;
	static class Vertex {
	    Vertex l, r;
	    int sum;
	    int id;

	    Vertex(int val){
	    	this.sum = val;
	    	this.id = globid++;
	    }
	    Vertex(Vertex l, Vertex r){
	    	this.l = l; this.r = r; this.sum = 0;
	    	if(l != null) this.sum += l.sum;
	    	if(r != null) this.sum += r.sum;
	    	this.id = globid++;
	    }
	    public String toString() {
	    	int lid = l == null ? -1 : l.id;
	    	int rid = r == null ? -1 : r.id;
	    	return id+" - l:"+lid+" r:"+rid+" ("+sum+")";
	    }
	}
	static class PST{
		static Vertex build(int a[], int tl, int tr) {
		    if (tl == tr)
		        return new Vertex(a[tl]);
		    int tm = (tl + tr) / 2;
		    return new Vertex(build(a, tl, tm), build(a, tm+1, tr));
		}

		static int get_sum(Vertex v, int tl, int tr, int l, int r) {
		    if (l > r)
		        return 0;
		    if (l == tl && tr == r)
		        return v.sum;
		    int tm = (tl + tr) / 2;
		    return get_sum(v.l, tl, tm, l, Math.min(r, tm))
		         + get_sum(v.r, tm+1, tr, Math.max(l, tm+1), r);
		}

		static Vertex update(Vertex v, int tl, int tr, int pos, int new_val) {
		    if (tl == tr)
		        return new Vertex(new_val);
		    int tm = (tl + tr) / 2;
		    if (pos <= tm)
		        return new Vertex(update(v.l, tl, tm, pos, new_val), v.r);
		    else
		        return new Vertex(v.l, update(v.r, tm+1, tr, pos, new_val));
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
