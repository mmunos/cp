import java.util.*;

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		ArrayList<Edge>[] g = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			g[i] = new ArrayList<>();
		}
		int s = 0, t = n-1;
		long maxv = 2000000000;
		PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingLong(p -> p.w));
		long[] dist = new long[n];
		int[] prev = new int[n];
		Arrays.fill(dist, maxv);
		dist[s] = 0;
		q.add(new Pair(s, 0));
		Arrays.fill(prev, -1);
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(Edge e: g[p.u]) {
				long dv = dist[p.u] + e.w;
				if(dv < dist[e.v]) {
					dist[e.v] = dv;
					prev[e.v] = p.u;
					q.add(new Pair(e.v, dist[e.v]));
				}
			}
		}
		System.out.println(dist[t]);

	}
	static class Pair implements Comparable<Pair>{
		int u; long w;
		public Pair(int u, long w){
			this.u = u; this.w = w;
		}
		public int compareTo(Pair p){
			return Long.compare(w, p.w);
		}
		public String toString(){
			return u + " " + w;
		}
	}
	static class Edge{
		int v; long w;
		public Edge(int v, long w) {
			this.v = v; this.w = w;
		}
	}

}
