import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		PrintWriter pw = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			char[] s = sc.next().toCharArray();
			if(n % k != 0) {
				sb.append("-1\n");
			}
			else {
				int[] c = new int[26];
				for(int i = 0; i < n; i++) {
					c[s[i]-'a']++;
				}
				boolean yes = true;
				for(int h = 0; h < 26; h++) {
					if(c[h] % k != 0) {
						yes = false;
					}
				}
				if(yes) {
					sb.append(s);
					sb.append("\n");
					continue;
				}
				boolean found = false;
				for(int i = n-1; i >= 0; i--) {
					c[s[i]-'a']--;
					while(s[i] < 'z') {
						s[i]++;
						c[s[i]-'a']++;
						int dif = 0;
						for(int h = 0; h < 26; h++) {
							if(c[h] % k != 0) {
								dif += k - c[h]%k;
							}
						}
						if(dif <= n-i-1) {
							PriorityQueue<Character> q = new PriorityQueue<>();
							for(int h = 0; h < 26; h++) {
								if(c[h] % k != 0) {
									for(int j = 0; j < k - c[h]%k; j++) {
										q.add((char)(h+'a'));
									}
								}
							}
							while(q.size() < n-i-1) q.add('a');
							for(int j = i+1; j < n; j++) {
								s[j] = q.poll();
							}
							found = true;
							break;
						}
						c[s[i]-'a']--;
					}
					if(found) break;
				}
				sb.append(s);
				sb.append("\n");
			}
		}
		pw.print(sb.toString());
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
