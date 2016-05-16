import java.io.*;
import java.util.*;
public class Candy {
	public static void main(String...thegame) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n == m && n == 0) return;
			int[] maxs = new int[n];
			for(int i = 0; i < n; i++){
				st = new StringTokenizer(br.readLine());
				int[] row = new int[m];
				for(int j = 0; j < m; j++){
					row[j] = Integer.parseInt(st.nextToken());
				}
				maxs[i] = max(row, m);
			}
			System.out.println(max(maxs,n));
		}
	}
	static int max(int[] arr, int n){
		if(n == 1) return arr[0];
		if(n == 2) return Math.max(arr[0],arr[1]);
		int[] dp = new int[n];
		dp[0] = arr[0]; dp[1] = arr[1]; dp[2] = arr[0]+arr[2];
		for(int i = 3; i < n; i++){
			dp[i] = Math.max(dp[i-3], dp[i-2]) + arr[i];
		}
		Arrays.sort(dp);
		return Math.max(dp[n-2], dp[n-1]);
	}
}
