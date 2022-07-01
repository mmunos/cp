import java.util.*;
public class p128 {
	
	public static void main(String...strings) {
		int n = 100;
		int N = 30000000;
		ArrayList<Integer>[] g = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			g[i] = new ArrayList<>();
		}
		int[] prev = new int[6];
		int u = 2;
		for(int i = 0; i < 6; i++) {
			prev[i] = u;
			g[1].add(u); g[u].add(1);
			u++;
		}
		for(int r = 0; r < 6; r++) {
			g[prev[r]].add(prev[(r+1)%6]);
			g[prev[(r+1)%6]].add(prev[r]);
		}
		for(int i = 1; i < n; i++) { //level
			ArrayList<Integer> level = new ArrayList<>();
			int[] curr = new int[6];
			for(int r = 0; r < 6; r++) { //sector
				curr[r] = u;
				g[prev[r]].add(u); g[u].add(prev[r]);
				level.add(u); u++;
				for(int j = 1; j <= i; j++) {
					int a = prev[r] + j-1;
					int b = a + 1;
					if(b == curr[0]) b = prev[0];
					g[a].add(u); g[u].add(a);
					g[b].add(u); g[u].add(b);
					level.add(u); u++;
				}
			}
			int m = level.size();
			for(int r = 0; r < level.size(); r++) {
				g[level.get(r)].add(level.get((r+1)%m));
				g[level.get((r+1)%m)].add(level.get(r));
			}
			prev = curr;
		}
		for(int i = 1; i < 200; i++) {
			System.out.print(i+": ");
			for(int e: g[i]) {
				System.out.print(" "+Math.abs(e - i));
			}
			System.out.println("");
		}
//		int c = 0;
//		for(int i = 1; i < N; i++) {
//			if(check(g[i], i)) {
//				c++;
//				System.out.println(c+": "+i);
//			}
//		}
	}
	static boolean check(ArrayList<Integer> edges, int n) {
		int c = 0;
		for(int e: edges) {
			if(isPrime(Math.abs(e - n))) c++;
		}
		return c == 3;
	}
	static boolean isPrime(long x) {
		if(x == 1) return false;
		for(long d = 2; d*d <= x; d++) {
			if(x % d == 0) return false;
		}
		return true;
	}

}
