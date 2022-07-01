import java.util.*;
import java.io.*;
public class DEsopoPape {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Edge>[] g = new ArrayList[n];
		for(int i = 0; i < n; i++) g[i] = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			int w = sc.nextInt();
			g[u].add(new Edge(v, w));
		}
		int s = sc.nextInt()-1;
		int t = sc.nextInt()-1;
		
		int maxv = 1000000000;
		int[] dist = new int[n];
		Arrays.fill(dist, maxv);
		dist[s] = 0;
		int[] color = new int[n];
		Arrays.fill(color, 2);
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(s);
//		int[] prev = new int[n];
//		Arrays.fill(prev, -1);
		while(!q.isEmpty()) {
			int u = q.pollFirst();
			color[u] = 0;
			for(Edge e: g[u]) {
				if(dist[e.u] > dist[u] + e.w) {
					dist[e.u] = dist[u] + e.w;
//					prev[e.u] = u;
					if(color[e.u] == 2) {
						color[e.u] = 1;
						q.addLast(e.u);
					}
					else if(color[e.u] == 0) {
						color[e.u] = 1;
						q.addFirst(e.u);
					}
				}
			}
		}
		System.out.println(dist[t]);
	}
	static class Edge{
		int u, w;
		public Edge(int u, int w) {
			this.u = u; this.w = w;
		}
		public String toString() {
			return u+" ("+w+")";
		}
	}
}
