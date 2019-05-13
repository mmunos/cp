import java.util.*;
import java.io.*;
public class Main { // UvaLive 4210 - Almost Shortest Path

	static int MAX = 500001;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while(!(line = br.readLine()).equals("0 0")){
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			HashMap<Integer, Edge>[] g = new HashMap[n];
			for(int i = 0; i < n; i++){
				g[i] = new HashMap<>();
			}
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			for(int i = 0; i < m; i++){
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				g[u].put(v, new Edge(u, v, w));
			}
			//better dijkstra
			HashSet<Integer>[] prev = new HashSet[n]; //using a list instead of a set gives TLE
			for(int i = 0; i < n; i++){
				prev[i] = new HashSet<>();
			}
			int[] cost = new int[n];
			Arrays.fill(cost, MAX);
			PriorityQueue<Pair> q = new PriorityQueue<>();
			q.add(new Pair(s, 0));
			cost[s] = 0; 
			while(!q.isEmpty()){
				Pair u = q.poll();
				for(Edge v: g[u.x].values()){
					int newcost = cost[u.x] + v.w;
					if(newcost < cost[v.y]){
						prev[v.y] = new HashSet<>();
						prev[v.y].add(v.x);
						q.add(new Pair(v.y, newcost));
						cost[v.y] = newcost;
					}
					else if(newcost == cost[v.y]){
						prev[v.y].add(v.x);
						q.add(new Pair(v.y, newcost));
					}
				}
			}
			//bfs
			ArrayList<Integer> minvs = new ArrayList<>();
			ArrayList<Integer> q2 = new ArrayList<>();
			q2.add(d); minvs.add(d);
			while(!q2.isEmpty()){
				int u = q2.remove(0);
				for(Integer v: prev[u]){
					minvs.add(v);
					q2.add(v);
				}
			}
			//removal
			for(int v: minvs){
				for(Integer u: prev[v]){
					g[u].get(v).w = MAX;
				}
			}
			//dijkstra again
			Arrays.fill(cost, MAX);
			q = new PriorityQueue<>();
			q.add(new Pair(s, 0));
			cost[s] = 0; 
			while(!q.isEmpty()){
				Pair u = q.poll();
				for(Edge v: g[u.x].values()){
					int newcost = cost[u.x] + v.w;
					if(newcost < cost[v.y]){
						q.add(new Pair(v.y, newcost));
						cost[v.y] = newcost;
					}
				}
			}
			if(cost[d] == MAX){
				System.out.println(-1);
			}
			else{
				System.out.println(cost[d]);
			}
		}
	}
	static class Edge{
		int x, y, w;
		public Edge(int x, int y, int w){
			this.x = x; this.y = y; this.w = w;
		}
		public String toString(){
			return x+"-"+y+" ("+w+")";
		}
	}
	static class Pair implements Comparable<Pair>{
		int x; int w;
		public Pair(int x, int w){
			this.x = x; this.w = w;
		}
		@Override
		public int compareTo(Pair p){
			if(w-p.w == 0) return 0;
			if(w-p.w < 0) return -1;
			else return 1;
		}
		public String toString(){
			return x+", ("+w+")";
		}
	}

}
