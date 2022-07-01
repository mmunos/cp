import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			ArrayList<Integer> narr = new ArrayList<>();
			ArrayList<Integer> parr = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt();
				if(a < 0) narr.add(-a);
				else parr.add(a);
			}
			ArrayList<Integer> nbrr = new ArrayList<>();
			ArrayList<Integer> pbrr = new ArrayList<>();
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt();
				if(a < 0) nbrr.add(-a);
				else pbrr.add(a);
			}
			Collections.sort(narr);
			Collections.sort(nbrr);
			int res1 = calc(narr, nbrr);
			int res2 = calc(parr, pbrr);
			System.out.println(res1 + res2);
		}
		
	}
	static int calc(ArrayList<Integer> arr, ArrayList<Integer> brr) {
		int n = arr.size();
		int m = brr.size();
		if(n == 0 || m == 0) return 0;
		HashSet<Integer> spp = new HashSet<>();
		for(int i = 0; i < m; i++) {
			spp.add(brr.get(i));
		}
		int[] acc = new int[n+1];
		for(int i = n-1; i >= 0; i--) {
			acc[i] = acc[i+1];
			if(spp.contains(arr.get(i))) acc[i]++;
		}
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		for(int i = 0; i < n; i++) {
//			map.put(arr.get(i), i);
//		}
		int a = 0; //first unpushed box
		int b = 0; //first box is put in special place b
		int c = 0; //first place that is not touched by the row of boxes 
		while(b < m && brr.get(b) < arr.get(0)) b++;
		//first box is now on place b
		if(b == m) return 0;
		int res = 0;
		while(b < m) {
			while(a < n && brr.get(b) + a > arr.get(a)) a++; //update a
			while(c < m && brr.get(c) <= brr.get(b) + (a-1)) c++; //update c
			int curr = c - b + acc[a];
			res = Math.max(res, curr);
			b++;
		}
		return res;
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
