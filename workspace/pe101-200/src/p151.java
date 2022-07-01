import java.util.*;
public class p151 {

	public static void main(String[] args) {
		int[] init = {1,0,0,0,0};
		dp = new HashMap<>();
		System.out.println(calc(init));
	}
	static HashMap<String, Double> dp;
	static double calc(int[] arr) {
		String key = Arrays.toString(arr);
		if(dp.containsKey(key)) return dp.get(key);
		int n = arr.length;
		int tot = 0;
		for(int i = 0; i < n; i++) {
			tot += arr[i];
		}
		if(tot == 1 && arr[n-1] == 1) return 0;
		double res = 0;
		if(tot == 1 && arr[0] == 0) res = 1;
		for(int i = 0; i < n; i++) {
			if(arr[i] > 0) {
				int[] next = next(arr, i);
				double val = calc(next);
				res += val * arr[i] / tot;
			}
		}
		dp.put(key, res);
		return res;
	}
	static int[] next(int[] arr, int ind) {
		int[] res = arr.clone();
		res[ind]--;
		for(int i = ind+1; i < res.length; i++) {
			res[i]++;
		}
		return res;
	}

}
