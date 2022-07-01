import java.util.*;
public class p701d {

	static int n = 4;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		Random r = new Random();
		int N = 100000000;
		long tot = 0;
		for(int iter = 0; iter < N; iter++) {
			char[][] map = new char[n][n];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					double d = r.nextDouble();
					if(d >= 0.5) map[i][j] = 1;
				}
			}
			tot += calc(map);
		}
		System.out.println(tot*1.0/N);
	}
	static int calc(char[][] map) {
		boolean[][] seen = new boolean[n][n];
		int res = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(map[i][j] != 0 && !seen[i][j]) {
					LinkedList<Pair> q = new LinkedList<>();
					q.add(new Pair(i, j));
					seen[i][j] = true;
					int curr = 1;
					while(!q.isEmpty()) {
						Pair p = q.removeFirst();
						for(int[] d: dir) {
							int u = p.x + d[0], v = p.y + d[1];
							if(u >= 0 && u < n && v >= 0 && v < n && map[u][v] != 0 && !seen[u][v]) {
								seen[u][v] = true; curr++; q.add(new Pair(u, v));
							}
 						}
					}
					res = Math.max(res, curr);
				}
			}
		}
		return res;
	}
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x; this.y = y;
		}
		public String toString() {
			return x+" "+y;
		}
	}
	
}
	