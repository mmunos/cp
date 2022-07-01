import java.util.*;
public class AllGraphs { //by diam
	
//	1: {0=0}
//	2: {-1=0, 1=1}
//	3: {-1=0, 1=3, 3=7}
//	4: {-1=0, 1=13, 2=15, 3=7, 6=63}
//	5: {-1=0, 1=58, 2=29, 3=127, 4=63, 5=31, 6=15, 10=1023}
//	6: {-1=0, 1=246, 2=122, 3=61, 4=121, 5=1023, 6=511, 7=255, 8=127, 9=63, 10=31, 15=32767}
//	7: {-1=0, 1=1006, 2=502, 3=250, 4=125, 5=2419, 6=249, 7=16383, 8=8191, 9=4095, 10=2047, 11=1023, 12=511, 13=255, 14=127, 15=63, 21=2097151}
	
	
	public static void main(String[] args) {
		
		genprint(5, 31);
		
//		int n = 8;
//		for(int i = 1; i <= n; i++){
//			allgs(i);
//		}
	}
	static void genprint(int n, int mask) {
		ArrayList<Integer>[] g = new ArrayList[n];
		for(int i = 0; i < n; i++){
			g[i] = new ArrayList<>();
		}
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				if((mask & 1) > 0) {
					g[i].add(j);
					g[j].add(i);
				}
				mask >>= 1;
			}
		}
		for(int i = 0; i < n; i++){
			System.out.println(i+": "+g[i]);
		}
	}
	public static void allgs(int n) { // undirected
		int m = n*(n-1)/2;
		TreeMap<Integer, Integer> poss = new TreeMap<>();
		for(int i = 0; i < (1 << m); i++) {
			int c = calc(n, i);
			if(!poss.containsKey(c)) {
				poss.put(c, i);
			}
		}
		System.out.println(poss);
	}
	static int calc(int n, int mask) {
		ArrayList<Integer>[] g = new ArrayList[n];
		for(int i = 0; i < n; i++){
			g[i] = new ArrayList<>();
		}
		int maskorig = mask;
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				if((mask & 1) > 0) {
					g[i].add(j);
					g[j].add(i);
				}
				mask >>= 1;
			}
		}
		//check connected
		LinkedList<Integer> q = new LinkedList<>();
		boolean[] seen = new boolean[n];
		q.add(0);
		seen[0] = true;
		int c = 1;
		while(!q.isEmpty()){
			int u = q.remove();
			for(int v: g[u]) {
				if(!seen[v]) {
					seen[v] = true; c++;
					q.add(v);
				}
			}
		}
		if(c < n) return -1;
		return countdiam(g)/2;
	}
	static int countdiam(ArrayList<Integer>[] g) {
		int n = g.length;
		int[][] d = new int[n][n];
		int max = 0;
		for(int i = 0; i < n; i++){
			LinkedList<Integer> q = new LinkedList<>();
			Arrays.fill(d[i], -1);
			q.add(i);
			d[i][i] = 0;
			while(!q.isEmpty()){
				int u = q.remove();
				for(int v: g[u]) {
					if(d[i][v] < 0) {
						d[i][v] = d[i][u] + 1;
						max = Math.max(max, d[i][v]);
						q.add(v);
					}
				}
			}			
		}
		int c = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(d[i][j] == max) c++;
			}
		}
		return c;
		
	}

}
