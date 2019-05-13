import java.util.*;
import java.io.*;
public class Main { //ICPC latam 2017 Enigma - 8192

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine();
			if(line == null) return;
			StringTokenizer st = new StringTokenizer(line);
			char[] arr = st.nextToken().toCharArray();
			int n = Integer.parseInt(st.nextToken());
			int s = arr.length;
			int[] pow = new int[s];
			pow[s-1] = 1;
			for(int i = s-2; i >= 0; i--){
				pow[i] = (pow[i+1]*10) % n;
			}
			int[][] dp = new int[s][n];
			for(int i = 0; i < s; i++){
				Arrays.fill(dp[i], -1);
			}
			if(arr[s-1] == '?'){
				for(int d = 9; d >= (s==1?1:0); d--){
					dp[s-1][d%n] = d;
				}
			}
			else{
				dp[s-1][(arr[s-1]-'0')%n] = arr[s-1]-'0';
			}
			
			for(int i = s-2; i >= 0; i--){
				if(arr[i] == '?'){
					for(int d = 9; d >= (i==0?1:0); d--){
						for(int m = 0; m < n; m++){
							if(dp[i+1][m] >= 0){
								dp[i][(d*pow[i]+m)%n] = d;
							}
						}
					}
				}
				else{
					int d = arr[i]-'0';
					for(int m = 0; m < n; m++){
						if(dp[i+1][m] >= 0){
							dp[i][(d*pow[i]+m)%n] = d;
						}
					}
				}
			}
			if(dp[0][0] < 0){
				System.out.println("*");
			}
			else{
				StringBuilder sb = new StringBuilder();
				int d = dp[0][0];
				sb.append(d);
				int tot = (d*pow[0])%n;
				for(int i = 1; i < s; i++){
					sb.append(dp[i][(n-tot)%n]);
					tot = (tot + dp[i][(n-tot)%n]*pow[i])%n;
				}
				System.out.println(sb.toString());
			}
		}

	}

}
