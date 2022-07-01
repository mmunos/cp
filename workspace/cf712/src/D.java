import java.util.*;
import java.io.*;
public class D { //on hold

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[2*n];
		TreeSet<Integer> all = new TreeSet<Integer>();
		int[] side = new int[2*n];
		for(int i = 0; i < n; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			side[u] = 1;
			side[v] = -1;
			all.add(u);
			all.add(v);
			p[u] = v; p[v] = u;
		}
		int res = 0;
		while(!all.isEmpty()) {
			int curr = 0;
			int ops = 0;
			boolean valid = true;
			while(true) {
				//up
				int u = all.pollFirst();
				ops++;
				if(side[u] < 0) curr++;
				int v = p[u];
				all.remove(v);
				int maxlow = 2*n;
				while(all.higher(v) != null) {
					int w = all.higher(v);
					int z = p[w];
					if(z > v) {
						valid = false; break;
					}
					maxlow = Math.max(maxlow, z);
				}
				
			}
		}
		
	}
//	static class Pair{
//		long a, b;
//		public Pair(long a, long b) {
//			this.a = a; this.b = b;
//		}
//		public String toString() {
//			return a+" "+b;
//		}
//	}

}
