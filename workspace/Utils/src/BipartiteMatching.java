import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteMatching {

	
	static class HopcroftKarp { //graph is undirected (bidirected)
		ArrayList<Integer>[] g;
		int[] dist, match;
		static final int inf = (int)1e9;
		int n, nil, matchSize = 0;
		HopcroftKarp(ArrayList<Integer>[] gg, int _n) {
			g = gg; n = _n; nil = -1;
			dist = new int[n+1]; match = new int[n+1];
			Arrays.fill(match, nil);
			Arrays.fill(dist, inf);
			while(bfs()) {
				for(int u = 0; u < n; u++) {
					if (match[u] == nil && dfs(u)) ++matchSize;
				}
			}
		}

		boolean bfs() {
			ArrayList<Integer> q = new ArrayList<>();
			for (int u = 0; u < n; u++) {
				if(match[u] == nil){
					dist[u] = 0; q.add(u);
				} else dist[u] = inf;
			}
			dist[nil] = inf;
			while (!q.isEmpty()){
				int u = q.remove(0);
				if(u != nil){
					for(int v: g[u]){
						if(dist[match[v]] == inf){
							dist[match[v]] = dist[u]+1;
							q.add(match[v]);
						}
					}
				}
			}
			return (dist[nil] != inf);
		}	

		boolean dfs(int u) {
			if(u == nil) return true;
			for(int v: g[u]){
				if(dist[match[v]] == dist[u]+1 && dfs(match[v])){
					match[v] = u; match[u] = v;
					return true;
				}
			}
			dist[u] = inf;
			return false;
		}
	}
}
