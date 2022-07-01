import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sbres = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int c = 0;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				c += arr[i];
			}
			if(c % 2 == 1) {
				sbres.append("NO\n"); continue;
			}
			StringBuilder sb = new StringBuilder();
			int res = 0;
			int ind = 0;
			while(ind < n && arr[ind] == 1) {
				ind++;
			}
			if(ind == n) {
				sbres.append("NO\n"); continue;
			}
			if(ind % 2 == 1) {
				ind--;
				while(ind < n-2 && count(arr, ind) != 2) {
					sb.append((ind+1)+" "); res++;
					arr[ind+1] = 1; arr[ind+2] = 1;
					ind += 2;
				}
				if(ind >= n-2) {
					sbres.append("NO\n"); continue;
				}
				else {
					while(ind > 0) {
						sb.append((ind+1)+" "); res++;
						arr[ind] = 0; arr[ind+1] = 0; arr[ind+2] = 0;
						ind -= 2;
					}
				}
			}
			else {
				ind -= 2;
				while(ind > 0) {
					sb.append((ind+1)+" "); res++;
					arr[ind] = 0; arr[ind+1] = 0; arr[ind+2] = 0;
					ind -= 2;
				}
				
			}
			for(int i = 0; i < n-2; i++) {
				int ca = count(arr, i);
				if(ca == 2) {
					sb.append((i+1)+" "); res++;
					arr[i] = 0; arr[i+1] = 0; arr[i+2] = 0;
				}
				else {
					if(ca == 1) {
						if(arr[i] == 0);
						else {
							sb.append((i+1)+" "); res++;
							arr[i] = 1; arr[i+1] = 1; arr[i+2] = 1;
							sb.append(i+" "); res++;
							arr[i-1] = 0; arr[i] = 0; arr[i+1] = 0;
						}
					}
				}
			}
			if(res == 0) {
				sbres.append("YES\n0\n");
			}
			else {
				sbres.append("YES\n"+res+"\n");
				sb.replace(sb.length()-1, sb.length(), "\n");
				sbres.append(sb);
			}
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sbres.toString().trim());
		pw.flush();
	}
	static int count(int[] arr, int pos) {
		return arr[pos] + arr[pos+1] + arr[pos+2];
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
