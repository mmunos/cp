import java.io.*;
import java.util.*;
public class AlmostShortestPath {
	static ArrayList<Node>[] g;
	static int n;
	public static void main(String...thegame) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()); if(n == 0) return;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g = new ArrayList[n];
			for(int u = 0; u < n; u++) g[u] = new ArrayList<>();
			for(int i = 0; i < m; i++){
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				g[u].add(new Node(v,d));
			}
			
			int min = dijkstra(a, b, 0);
			if(min == -1){
				System.out.println("-1"); continue;
			}
			System.out.println(dijkstra(a, b, 1));
		}
	}
	static int dijkstra(int a, int b, int d){
		PriorityQueue<Node> q = new PriorityQueue<>();
		int[] dist = new int[n];
		Arrays.fill(dist,-1); dist[a] = 0;
		ArrayList<Integer>[] prev = new ArrayList[n];
		for(int u = 0; u < n; u++) prev[u] = new ArrayList<>();
		boolean[] seen = new boolean[n];
		q.add(new Node(a,0));
		boolean found = false;
		while(!q.isEmpty()){
			Node u = q.poll(); if(u.id == b) {found = true; break;}
			if(seen[u.id]) continue;
			for(Node v: g[u.id]){
				if(dist[v.id] < 0 || dist[v.id] > dist[u.id] + v.d){
					dist[v.id] = dist[u.id] + v.d;
					prev[v.id] = new ArrayList<>();
					prev[v.id].add(u.id);
					q.add(new Node(v.id,dist[v.id]));
				}
				else if(dist[v.id] == dist[u.id] + v.d){
					prev[v.id].add(u.id);
				}
			}
			seen[u.id] = true;
		}
		if(!found) return -1;
		if(d == 0){
			ArrayList<Integer> qu = new ArrayList<>();
			qu.add(b);
			while(!qu.isEmpty()){
				int u = qu.remove(0);
				for(int v: prev[u]){
					ArrayList<Node> toremove = new ArrayList<>();
					for(Node w: g[v]){
						if(w.id == u){
							toremove.add(w);
						}
					}
					for(Node w: toremove){
						g[v].remove(w);
					}
					qu.add(v);
				}
			}
		}
		return dist[b];
	}
	static class Node implements Comparable<Node>{
		int id, d;
		public Node(int u, int d){
			this.id = u; this.d = d;
		}
		public int compareTo(Node o){
			return d - o.d;
		}
		public String toString(){
			return id + " (" + d + ")";
		}
	}
}
