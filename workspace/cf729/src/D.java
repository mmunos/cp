import java.util.*;
import java.io.*;
public class D {

	static long mod = 998244353;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		long[] arr = new long[n];
		for(int i = 0; i < n; i++) {
			char[] s = sc.next().toCharArray();
			if(s[0] == '+') {
				long a = sc.nextLong();
				arr[i] = a;
			}
			else arr[i] = -1;
		}
		long res = 0;
		int[][] dp = new int[n+1][n];
		for(int ind = 0; ind < n; ind++) {
			if(arr[ind] > 0) {
				for(int i = 0; i <= n; i++) {
					for(int j = 0; j < n; j++) {
						dp[i][j] = 0;
					}
				}
				dp[0][0] = 1;
                for(int i = 0; i < ind; i++) {
                    for(int j = 0; j < n; j++) {
                    	dp[i+1][j] = sum(dp[i+1][j], dp[i][j]); 
                        if(arr[i] == -1) {
                            if(j > 0) {
                            	dp[i+1][j-1] = sum(dp[i+1][j-1], dp[i][j]);
                            }
                            else {
                                dp[i+1][j] = sum(dp[i+1][j], dp[i][j]);
                            }
                        }
                        else if(arr[i] <= arr[ind]) {
                            if(j < n-1) {
                                dp[i+1][j+1] = sum(dp[i+1][j+1], dp[i][j]);
                            }
                        }
                        else { //if(arr[i] > arr[ind])
                            dp[i+1][j] = sum(dp[i+1][j], dp[i][j]);
                        }
                    }
                }
                for(int j = 0; j < n; j++) {
                    dp[ind+1][j] = dp[ind][j];
                }
                for(int i = ind+1; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                    	dp[i+1][j] = sum(dp[i+1][j], dp[i][j]); 
                        if(arr[i] == -1) {
                            if(j > 0) {
                            	dp[i+1][j-1] = sum(dp[i+1][j-1], dp[i][j]);
                            }
                            else {
                                //dp[i+1][j] = sum(dp[i+1][j], dp[i][j]);
                            }
                        }
                        else if(arr[i] < arr[ind]) {
                            if(j < n-1) {
                                dp[i+1][j+1] = sum(dp[i+1][j+1], dp[i][j]);
                            }
                        }
                        else { //if(arr[i] > arr[ind])
                            dp[i+1][j] = sum(dp[i+1][j], dp[i][j]);
                        }
                    }
                }
                int curr = 0;
        		for(int j = 0; j < n; j++) {
        			curr = sum(curr, dp[n][j]);
        		}
				res += curr * arr[ind] % mod; res %= mod;
			}
		}
		System.out.println(res);
		
	}
	static int sum(int a, int b) {
		if(a + b >= mod) return (int)(a + b - mod);
		else return a + b;
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
