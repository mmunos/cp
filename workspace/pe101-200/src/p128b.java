import java.util.*;
public class p128b {
	
	public static void main(String...strings) {
		int n = 70000;
		long[][] pivs = new long[n][6];
		Arrays.fill(pivs[0], 1);
		long u = 2;
		for(int i = 1; i < n; i++) {
			for(int r = 0; r < 6; r++) {
				pivs[i][r] = u;
				u += i;
			}
		}
		ArrayList<Long> list = new ArrayList<>();
		list.add(1L);
		for(int i = 1; i < n-2; i++) {
			long v0 = pivs[i][0];
			ArrayList<Long> edges = new ArrayList<>();
			edges.add(pivs[i-1][0]);
			edges.add(pivs[i+1][0]-1);
			edges.add(pivs[i+2][0]-1);
			edges.add(pivs[i+1][0]);
			edges.add(pivs[i+1][0]+1);
			if(check(v0, edges)) list.add(v0);
			for(int r = 1; r < 6; r++) {
				long v = pivs[i][r];
				edges = new ArrayList<>();
				edges.add(pivs[i-1][r]);
				edges.add(pivs[i+1][r]-1);
				edges.add(pivs[i+1][r]);
				edges.add(pivs[i+1][r]+1);
				if(check(v, edges)) list.add(v);
			}
			long vf = pivs[i+1][0]-1;
			edges = new ArrayList<>();
			edges.add(pivs[i][0]-1);
			edges.add(pivs[i-1][0]);
			edges.add(pivs[i][0]);
			edges.add(pivs[i+2][0]-2);
			edges.add(pivs[i+2][0]-1);
			if(check(vf, edges)) list.add(vf);
		}
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(9));
		System.out.println(list.get(1999));
	}
	static boolean check(long u, ArrayList<Long> edges) {
		int c = 0;
		for(long e: edges) {
			if(isPrime(Math.abs(e - u))) c++;
		}
		return c == 3;
	}
	static boolean isPrime(long x) {
		if(x == 1) return false;
		long sqx = (long)Math.sqrt(x);
		for(long d = 2; d <= sqx; d++) {
			if(x % d == 0) return false;
		}
		return true;
	}

}
