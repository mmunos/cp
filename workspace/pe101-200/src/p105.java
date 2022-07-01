import java.util.*;
public class p105 {
	
	public static void main(String...strings) {
		Scanner sc  = new Scanner(System.in);
		int T = sc.nextInt();
		long res = 0;
		while(T--> 0) {
			String[] vals = sc.next().split(",");
			int n = vals.length;
			long[] arr = new long[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(vals[i]);
			}
			Arrays.sort(arr);
			long[] acc = new long[n+1];
			for(int i = 0; i < n; i++) {
				acc[i+1] = acc[i] + arr[i];
			}
			int ln = 1;
			boolean yes = true;
			while(ln + ln+1 <= n) {
				if(acc[n] - acc[n-ln] > acc[ln+1]) yes = false;
				ln++;
			}
			if(!yes) continue;
			HashSet<Long> testset = new HashSet<>();
			for(int mask = 0; mask < (1<<n); mask++) {
				long tot = 0;
				for(int i = 0; i < n; i++) {
					if((mask & (1 << i)) > 0) tot += arr[i];
				}
				testset.add(tot);
			}
			if(testset.size() == (1 << n)) {
				for(long a: arr) res += a;
			}
		}
		System.out.println(res);
	}

}
