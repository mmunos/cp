import java.util.*;
import java.io.*;
public class E {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		sc.nextInt(); //m
		int[] arr = new int[n];
		int[][] liml = new int[n][2];
		int[][] limr = new int[n][2];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			for(int k = 0; k < 2; k++) {
				liml[i][k] = sc.nextInt();
			}
			for(int k = 0; k < 2; k++) {
				limr[i][k] = sc.nextInt();
			}
		}
		int[] maxl = new int[n+1];
		int[] maxr = new int[n+1];
		TreeSet<Pair> ls = new TreeSet<>();
		TreeSet<Pair> rs = new TreeSet<>();
		ls.add(new Pair(0, 0));
		rs.add(new Pair(0, 0));
		for(int i = 0; i < n; i++) {
			ls.add(new Pair(i+1, arr[i]));
			rs.add(new Pair(i+1, arr[i]));
			while(!ls.isEmpty() && ls.first().val < liml[i][0]) {
				Pair p = ls.pollFirst();
				maxl[p.ind] = i;
			}
			while(!ls.isEmpty() && ls.last().val > liml[i][1]) {
				Pair p = ls.pollLast();
				maxl[p.ind] = i;
			}
			while(!rs.isEmpty() && rs.first().val < limr[i][0]) {
				Pair p = rs.pollFirst();
				maxr[p.ind] = i;
			}
			while(!rs.isEmpty() && rs.last().val > limr[i][1]) {
				Pair p = rs.pollLast();
				maxr[p.ind] = i;
			}
		}
		for(Pair p: rs) {
			maxr[p.ind] = n;
		}
		for(Pair p: ls) {
			maxl[p.ind] = n;
		}
		int[] statl = new int[n+1];
		Arrays.fill(statl, -1);
		int[] statr = new int[n+1];
		Arrays.fill(statr, -1);
		if(maxl[n] == n) statl[n] = n;
		if(maxr[n] == n) statr[n] = n;
		char[] pickl = new char[n+1];
		char[] pickr = new char[n+1];
		for(int i = n-1; i >= 0; i--) {
			//left
			if(statr[i+1] >= 0 && statr[i+1] <= maxl[i]) {//left now, right next turn
				statl[i] = i; pickl[i] = 'r';
			}
			else if(maxl[i] >= i && statl[i+1] >= 0) {//left now, left next turn
				statl[i] = statl[i+1]; pickl[i] = 'l';
			}
			//right
			if(statl[i+1] >= 0 && statl[i+1] <= maxr[i]) {//right now, left next turn
				statr[i] = i; pickr[i] = 'l';
			}
			else if(maxr[i] >= i && statr[i+1] >= 0) {//right now, right next turn
				statr[i] = statr[i+1]; pickr[i] = 'r';
			}
		}
		StringBuilder sb = new StringBuilder();
		if(pickl[0] == 'r' || pickr[0] == 'l') {
			sb.append("Yes\n");
			int s;
			if(pickl[0] == 'r') s = 1;
			else s = 0;
			sb.append(s+"");
			for(int i = 1; i < n; i++) {
				if(s == 1) {
					if(pickr[i] == 'l') s = 0;
					else if(pickr[i] == 'r') s = 1;
				}
				else if(s == 0) {
					if(pickl[i] == 'l') s = 0;
					else if(pickl[i] == 'r') s = 1; 
				}
				sb.append(" "+s);
			}
			sb.append("\n");
		}
		else {
			System.out.println("No");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static class Pair implements Comparable<Pair>{
		int ind, val;
		public Pair(int ind, int val) {
			this.ind = ind; this.val = val;
		}
		public int compareTo(Pair p) {
			if(val == p.val) return ind - p.ind;
			else return val - p.val;
		}
		public String toString() {
			return ind+" "+val;
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
