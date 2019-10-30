import java.util.*;
import java.io.*;
public class SignOfMatrix {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int caso = 1; ; caso++) {
			int n = Integer.parseInt(br.readLine());
			if(n < 0) break;
			char[][] map = new char[n][];
			UnionFind uf = new UnionFind(2*n); // 0 - (n-1) represent rows n - (2n-1) represent (-1)*columns 
			for(int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0; j < n; j++) {
					if(map[i][j] == '0') {
						uf.union(i, n + j);
					}
				}
			}
			int N = 2*n;
			int[] us = new int[N];
			for(int i = 0; i < N; i++) {
				us[uf.find(i)]++;
			}
			boolean[][] gmat = new boolean[N][N];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == '+') {
						int u = uf.find(i), v = uf.find(n+j);
						gmat[u][v] = true;
					}
					else if(map[i][j] == '-') {
						int u = uf.find(i), v = uf.find(n+j);
						gmat[v][u] = true;
					}
				}
			}
			g = new ArrayList[N];
			for(int i = 0; i < N; i++) {
				g[i] = new ArrayList<Integer>();
			}
			int[] indeg = new int[N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(gmat[i][j]) {
						g[i].add(j); 
						indeg[j]++;
					}
				}
			}
			mark = new int[N];
			boolean cycle = false;
			for(int i = 0; i < N; i++) {
				if(mark[i] == 0 && uf.find(i) == i) {
					if(dfs(i)) {
						cycle = true; break;
					}
				}
			}
			if(cycle) {
				bw.write(String.format("Case %d: %d\n", caso, -1)); continue;
			}
			//toposort
			LinkedList<Integer> q = new LinkedList<>();
			int[] level = new int[N];
			Arrays.fill(level, -1);
			for(int i = 0; i < N; i++) {
				if(indeg[i] == 0 && uf.find(i) == i) {
					q.add(i);
					level[i] = 0;
				}
			}
			while(!q.isEmpty()) {
				int u = q.removeFirst();
				for(int v: g[u]) {
					indeg[v]--;
					if(indeg[v] == 0) {
						level[v] = level[u]+1;
						q.add(v);
					}
				}
			}
			int res = Integer.MAX_VALUE;
			for(int offset = 0; offset < N; offset++) {
				int curr = 0;
				for(int i = 0; i < N; i++) {
					if(uf.find(i) != i) continue;
					curr += Math.abs(offset-level[i]) * us[i];
				}
				res = Integer.min(curr, res);
			}
			bw.write(String.format("Case %d: %d\n", caso, res));
		}
		bw.flush();
	}
	static int[] mark;
	static boolean dfs(int u) {
		mark[u] = 1;
		for(int v: g[u]) {
			if(mark[v] == 0) {
				if(dfs(v)) return true;
			}
			else if(mark[v] == 1) {
				return true;
			}
		}
		mark[u] = 2;
		return false;
	}
	static ArrayList<Integer>[] g;
	static class UnionFind {
		//source: https://www.cs.waikato.ac.nz/~bernhard/317/source/graph/UnionFind.java
		private int[] _parent;
		private int[] _rank;

		public UnionFind(int max) {
			_parent = new int[max];
			_rank = new int[max];
			for (int i = 0; i < max; i++) {
				_parent[i] = i;
			}
		}

		public int find(int i) {
			int p = _parent[i];
			if (i == p) {
				return i;
			}
			return _parent[i] = find(p);
		}

		public void union(int i, int j) {
			int root1 = find(i), root2 = find(j);
			if (root2 == root1) return;
			if (_rank[root1] > _rank[root2]) {
				_parent[root2] = root1;
			} else if (_rank[root2] > _rank[root1]) {
				_parent[root1] = root2;
			} else {
				_parent[root2] = root1;
				_rank[root1]++;
			}
		}
	}
}
