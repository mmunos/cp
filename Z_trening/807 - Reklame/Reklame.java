import java.util.*;
import java.io.*;
public class zi {

	public static void main(String[] args) throws Exception {
//		long time0 = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> vmasks = new ArrayList<Integer>();
		int N = 1 << (7*3);
		int M = 0;
		int[] maskindex = new int[N];
		Arrays.fill(maskindex, -1);
		int[] size = new int[N];
		for(int i = 0; i < Math.pow(k+1, 7); i++) {
			int mask = 0, aux = i, c = 0;
			for(int ind = 0; ind < 7; ind++) {
				mask += (aux % (k+1)) << (3 * ind);
				if(aux > 0) c++;
				aux /= (k+1);
			}
			vmasks.add(mask);
			maskindex[mask] = M; M++;
			size[mask] = c;
		}
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			arr[i] = 1;
			for(int j = 1; j < c; j++) {
				int t = Integer.parseInt(st.nextToken());
				arr[i] |= (1 << ((t-1)*3));
			}
		}
		int max = 7*n+1;
		int[][] dp = new int[n][M];
		for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
		dp[0][maskindex[arr[0]]] = 0;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < M; j++) {
				if(dp[i-1][j] < 0) continue; //opt
				int mask = vmasks.get(j);
				int aux = mask;
				for(int d = 0; d <= 7; d++, aux >>= 3) {
					if(maskindex[aux + arr[i]] < 0) continue;
					if(dp[i][maskindex[aux + arr[i]]] < 0 || dp[i][maskindex[aux + arr[i]]] > dp[i-1][j] + d) {
						dp[i][maskindex[aux + arr[i]]] = dp[i-1][j] + d;
					}					
				}
			}
		}
		int res = max;
		for(int i = 0; i < M; i++) {
			if(dp[n-1][i] < 0) continue;
			res = Math.min(res, dp[n-1][i] + size[vmasks.get(i)]);
		}
		System.out.println(res);
		
//		long time1 = System.currentTimeMillis();
//		System.out.println(time1 - time0);
	}
}
