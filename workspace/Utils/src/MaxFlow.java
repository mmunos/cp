import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxFlow {

	static int MAX = 100000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		List<MaxFlowDinic.Edge>[] g = MaxFlowDinic.createGraph(n);
		int[][] gmat = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(gmat[i][j] > 0){
					MaxFlowDinic.addEdge(g, i, j, gmat[i][j]);
					MaxFlowDinic.addEdge(g, j, i, gmat[i][j]);
				}
			}
		}
		
		int res = MaxFlowDinic.maxFlow(g, n, n+1);
		
	}
	static class MaxFlowDinic {
		//from https://sites.google.com/site/indy256/algo/dinic_flow

		static class Edge {
			int t, rev, cap, f;

			public Edge(int t, int rev, int cap) {
				this.t = t;
				this.rev = rev;
				this.cap = cap;
			}
			public String toString(){
				return t+" r:"+rev+" c:"+cap+" f:"+f;
			}
		}

		public static List<Edge>[] createGraph(int nodes) {
			List<Edge>[] graph = new List[nodes];
			for(int i = 0; i < nodes; i++){
				graph[i] = new ArrayList<>();
			}
			return graph;
		}

		public static void addEdge(List<Edge>[] graph, int s, int t, int cap) {
			graph[s].add(new Edge(t, graph[t].size(), cap));
			graph[t].add(new Edge(s, graph[s].size() - 1, 0));
		}

		static boolean dinicBfs(List<Edge>[] graph, int src, int dest, int[] dist) {
			Arrays.fill(dist, -1);
			dist[src] = 0;
			int[] Q = new int[graph.length];
			int sizeQ = 0;
			Q[sizeQ++] = src;
			for(int i = 0; i < sizeQ; i++){
				int u = Q[i];
				for(Edge e : graph[u]){
					if(dist[e.t] < 0 && e.f < e.cap){
						dist[e.t] = dist[u] + 1;
						Q[sizeQ++] = e.t;
					}
				}
			}
			return dist[dest] >= 0;
		}

		static int dinicDfs(List<Edge>[] graph, int[] ptr, int[] dist, int dest, int u, int f) {
			if (u == dest)
				return f;
			for(; ptr[u] < graph[u].size(); ++ptr[u]){
				Edge e = graph[u].get(ptr[u]);
				if(dist[e.t] == dist[u] + 1 && e.f < e.cap){
					int df = dinicDfs(graph, ptr, dist, dest, e.t, Math.min(f, e.cap - e.f));
					if(df > 0){
						e.f += df;
						graph[e.t].get(e.rev).f -= df;
						return df;
					}
				}
			}
			return 0;
		}

		public static int maxFlow(List<Edge>[] graph, int src, int dest) {
			int flow = 0;
			int[] dist = new int[graph.length];
			while(dinicBfs(graph, src, dest, dist)){
				int[] ptr = new int[graph.length];
				while(true){
					int df = dinicDfs(graph, ptr, dist, dest, src, Integer.MAX_VALUE);
					if (df == 0) break;
					flow += df;
				}
			}
			return flow;
		}
	}

}
