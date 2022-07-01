import java.util.*;
public class CentroidDecomposition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		g = new ArrayList[n];
		for(int i = 0; i < n; i++) g[i] = new ArrayList<>();
		for(int i = 0; i < n-1; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			g[u].add(v);
			g[v].add(u);
		}
		size = new int[n];
		d = new int[n];
		isCent = new boolean[n];
		centroidDecomp(0, 0);
//		System.out.println(Arrays.toString(d));
		ArrayList<Integer>[] ds = new ArrayList[4];
		for(int i = 0; i < 4; i++) ds[i] = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			ds[d[i]].add(i+1);
		}
		for(int i = 0; i < 4; i++) {
			System.out.println(ds[i]);
		}
	}
	static ArrayList<Integer>[] g;
	static int[] size, d;
	static boolean[] isCent;
	static void centroidDecomp(int u, int depth){
		int s = dfs(u, -1);
		int cent = getCentroid(u, -1, s);
		
		isCent[cent] = true;
		d[cent] = depth;
		
		for(int v : g[cent]) {
			if(!isCent[v]) {
				centroidDecomp(v, depth+1);
			}
		}
	}
 
	static int getCentroid(int u, int p, int s){
		for(int v : g[u]) {
			if(v != p && !isCent[v] && size[v] > s/2) {
				return getCentroid(v, u, s);
			}
		}
		
		return u;
	}
 
	static int dfs(int u, int p) {
		size[u] = 1;
		for(int v : g[u]) {
			if(v != p && !isCent[v]) {
				size[u] += dfs(v, u);
			}
		}
		
		return size[u];
	}
}
