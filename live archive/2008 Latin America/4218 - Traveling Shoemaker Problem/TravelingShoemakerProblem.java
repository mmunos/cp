import java.util.*;
import java.io.*;
public class TravelingShoemakerProblem {
	public static void main(String...thegame) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); if(N == 0) return;
			ArrayList<Integer>[] cities = new ArrayList[N];
			for(int c = 0; c < N; c++) cities[c] = new ArrayList<>();
			int[] type = new int[N];
			for(int conf = 0; conf < C; conf++){
				st = new StringTokenizer(br.readLine());
				int K = Integer.parseInt(st.nextToken());
				for(int k = 0; k < K; k++){
					int c = Integer.parseInt(st.nextToken());
					cities[c].add(conf);
					type[c]++;
				}
			}
			//Now we cut the bullshit and create the graph
			ArrayList<Edge>[] g = new ArrayList[C];
			ArrayList<Integer>[] loop = new ArrayList[C];
			for(int u = 0; u < C; u++) {
				g[u] = new ArrayList<>(); loop[u] = new ArrayList<>();
			}
			for(int e = 0; e < N; e++){
				if(type[e]==1){
					loop[cities[e].get(0)].add(e);
				}
				else{
					int u = cities[e].get(0); int v = cities[e].get(1);
					g[u].add(new Edge(e,v)); g[v].add(new Edge(e,u));
				}
			}
			//iterate for each edge to check if can be in start
			int id = 0; boolean poss = true;
			for(; id < N; id++){
				if(type[id] == 2){
					int u = cities[id].get(0);
					int v = cities[id].get(1);
					for(Edge e: g[u]) if(e.v == v) {g[u].remove(e); break;}
					for(Edge e: g[v]) if(e.v == u) {g[v].remove(e); break;}
				}
				boolean[] needs_to_be_seen = new boolean[C];
				int first_conf_to_be_seen = 0;
				for(int u = 0; u < C; u++){
					for(Edge e: g[u]) {needs_to_be_seen[e.v] = true; first_conf_to_be_seen = e.v;}
					if(loop[u].size()>0) {needs_to_be_seen[u] = true; first_conf_to_be_seen = u;}
				}
				poss = true;
				//bfs to check if connected
				ArrayList<Integer> q = new ArrayList<>();
				q.add(first_conf_to_be_seen); boolean[] seen = new boolean[C]; 
				seen[first_conf_to_be_seen] = true;
				while(!q.isEmpty()){
					int u = q.remove(0);
					for(Edge e: g[u]){
						if(seen[e.v]) continue;
						q.add(e.v); seen[e.v] = true;
					}
				}
				//check if bfs sees every conf that needs to be seen
				for(int u = 0; u < C; u++){
					if(needs_to_be_seen[u] && !seen[u]){
						poss = false;
					}
				}
				//group all confederations which can be starting point
				ArrayList<Integer> start_confs = new ArrayList<>();
				int odds = 0;
				for(int u = 0; u < C; u++){
					if(g[u].size()%2!=0){
						start_confs.add(u);
						odds++;
					}
					if(odds > 2){
						poss = false; break;
					}
				}
				if(start_confs.size() > 0){
					if(type[id] == 2 && !start_confs.contains(cities[id].get(0)) && 
							!start_confs.contains(cities[id].get(1))){
						poss = false;
					}
					else if(type[id] == 1 && !start_confs.contains(cities[id].get(0))){
						poss = false;
					}
				}
				if(poss) break;
				else if(type[id] == 2){
					int u = cities[id].get(0); int v = cities[id].get(1);
					g[u].add(new Edge(id,v)); g[v].add(new Edge(id,u));
				}
			}
			if(poss) System.out.println(id);
			else System.out.println("-1");
		}	
	}
	static class Edge{
		int id, v;
		public Edge(int id, int v){
			this.id = id; this.v = v;
		}
		@Override
		public String toString(){
			return v + " (id:"+id+")";
		}
	}
}
