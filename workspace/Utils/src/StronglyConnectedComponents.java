import java.util.*;
public class StronglyConnectedComponents {

	//Kosaraju
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		g = new ArrayList[n]; g2 = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			g[i] = new ArrayList<>();
			g2[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			g[u].add(v);
			g2[v].add(u);
		}
		seen = new boolean[n];
		ord = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if(!seen[i]) {
				dfs(i);
			}
		}
		System.out.println(ord);
		Collections.reverse(ord);
		seen = new boolean[n];
		for(int u: ord) {
			if(!seen[u]) {
				comp = new ArrayList<>();
				dfs2(u);
				System.out.println(comp);
			}
		}
	}
	static boolean[] seen;
	static ArrayList<Integer>[] g, g2;
	static ArrayList<Integer> ord, comp;
	static void dfs(int u) {
		seen[u] = true;
		for(int v: g[u]) {
			if(!seen[v]) {
				dfs(v);
			}
		}
		ord.add(u);
	}
	static void dfs2(int u) {
		seen[u] = true;
		comp.add(u);
		for(int v: g2[u]) {
			if(!seen[v]) {
				dfs2(v);
			}
		}
	}
}
