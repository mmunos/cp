import java.util.*;

public class p755 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 20;
		long[] fib = new long[N+1];
		fib[0] = 1;
		fib[1] = 2;
		for(int i = 2; i <= N; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		System.out.println(Arrays.toString(fib));
		TreeMap<Long, Integer> f = new TreeMap<>();
		f.put(0L, 1);
		for(int i = 0; i <= N; i++) {
			f = update(f, fib[i]);
			System.out.println(f);
			sc.next();
		}
		long tot = 0;
		for(long k: f.keySet()) {
			if(k <= 10000) tot += f.get(k);
		}
		System.out.println(tot);
	}
	static TreeMap<Long, Integer> update(TreeMap<Long, Integer> f, long x){
		TreeMap<Long, Integer> res = new TreeMap<>(f);
		for(long v: f.keySet()) {
			res.put(v + x, res.getOrDefault(v+x, 0) + f.get(v));
		}
		return res;
	}

}
