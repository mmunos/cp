import java.util.*;

import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int a = k-1 + (n-(k-1))/2 + 1;
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int[] brr = arr.clone();
			sort(brr);
			int x = -1, y = -1;
			for(int i = 0, j = a-1; j < n; i++, j++) {
				if(x == -1 || y-x > brr[j] - brr[i]) {
					x = brr[i]; y = brr[j];
				}
			}
			sb.append(x+" "+y+"\n");
			int notinrange = 0;
			int last = 0;
			if(k > 1) {
				for(int i = 0; i < n; i++) {
					if(arr[i] >= x && arr[i] <= y) {
						notinrange--;
					}
					else {
						notinrange++;
					}
					if(notinrange < 0) {
						sb.append((last + 1)+" "+(i+1)+"\n");
						last = i+1;
						notinrange = 0;
						k--;
					}
					if(k == 1) break;
				}
			}
			sb.append((last+1)+" "+n+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();

	}
	
	static void sort(int[] arr) {
		Random r = new Random();
		for(int i = 0; i < arr.length; i++) {
			int ind = r.nextInt(arr.length);
			int aux = arr[ind]; arr[ind] = arr[i]; arr[i] = aux; 
		}
		Arrays.sort(arr);
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
