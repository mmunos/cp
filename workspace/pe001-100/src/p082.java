import java.util.*;
public class p082 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		PriorityQueue<Pair> q = new PriorityQueue<>();
		int[][] dist = new int[n][m];
		for(int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		for(int i = 0; i < n; i++) {
			q.add(new Pair(i, 0, arr[i][0]));
			dist[i][0] = arr[i][0];
		}
		int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
		while(!q.isEmpty()){
			Pair p = q.poll();
			for(int[] d: dir) {
				int x = p.x + d[0], y = p.y + d[1];
				if(x >= 0 && x < n && y >= 0 && y < m && dist[x][y] > dist[p.x][p.y] + arr[x][y]) {
					dist[x][y] = dist[p.x][p.y] + arr[x][y];
					q.add(new Pair(x, y, dist[x][y]));
				}
			}
		}
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			res = Math.min(res, dist[i][n-1]);
		}
		System.out.println(res);
	}
	
	static class Pair implements Comparable<Pair>{
		int x, y, w;
		public Pair(int x, int y, int w){
			this.x = x; this.y = y; this.w = w;
		}
		@Override
		public int compareTo(Pair p) {
			return w - p.w;
		}
		public String toString() {
			return x+" "+y+"("+w+")";
		}
	}

}
