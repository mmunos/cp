import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int[] arr = new int[n];
		ArrayList<Integer>[] poss = new ArrayList[2500001];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if(poss[arr[i]] == null) poss[arr[i]] = new ArrayList<>();
			poss[arr[i]].add(i+1);
		}
		ArrayList<Integer> twoormore = new ArrayList<>();
		for(int k = 1; k <= 2500000; k++) {
			if(poss[k] != null && poss[k].size() >= 4) {
				System.out.println("YES");
				System.out.printf("%d %d %d %d\n", poss[k].get(0), poss[k].get(1), poss[k].get(2), poss[k].get(3));
				return;
			}
			else if(poss[k] != null && poss[k].size() >= 2) {
				twoormore.add(k);
				if(twoormore.size() >= 2) {
					int a = twoormore.get(0);
					System.out.println("YES");
					System.out.printf("%d %d %d %d\n", poss[a].get(0), poss[k].get(0), poss[a].get(1), poss[k].get(1));
					return;
				}
			}
		}
		int m = n;
		if(m >= 2000) m = 2000;
		ArrayList<Pair>[] poss2 = new ArrayList[2500000];
		for(int i = 0; i < m; i++){
			for(int j = i+1; j < m; j++){
				if(arr[i] >= arr[j]) {
					if(poss2[arr[i] - arr[j]] == null) poss2[arr[i] - arr[j]] = new ArrayList<>();
					poss2[arr[i] - arr[j]].add(new Pair(i+1, j+1));
				}
				else {
					if(poss2[arr[j] - arr[i]] == null) poss2[arr[j] - arr[i]] = new ArrayList<>();
					poss2[arr[j] - arr[i]].add(new Pair(j+1, i+1));
				}
			}
		}
		for(int k = 0; k < 2500000; k++) {
			if(poss2[k] != null && poss2[k].size() > 1) {
				int mm = poss2[k].size();
				if(mm > 5) mm = 5;
				for(int i = 0; i < mm; i++){
					for(int j = i+1; j < mm; j++){
						Pair p = poss2[k].get(i);
						Pair q = poss2[k].get(j);
						if(alldif(p.a, p.b, q.a, q.b)) {
							System.out.println("YES");
							System.out.printf("%d %d %d %d\n", p.a, q.b, p.b, q.a);
							return;
						}
					}
				}
			}
		}
		System.out.println("NO");
	}
	static boolean alldif(int a, int b, int c, int d) {
		if(a == c) return false;
		if(a == d) return false;
		if(b == c) return false;
		if(b == d) return false;
		return true;
	}
	static class Pair{
		int a, b;
		public Pair(int a, int b) {
			this.a = a; this.b = b;
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
