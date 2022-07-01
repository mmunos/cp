import java.util.*;
public class Bslow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
		int n = sc.nextInt();
		String s = sc.next();
		String t = sc.next();
		int a = Integer.parseInt(s, 2);
		LinkedList<Integer> q = new LinkedList<>();
		q.add(a);
		int m = (1 << n);
		int[] dist = new int[m];
		Arrays.fill(dist, -1);
		dist[a] = 0;
		while(!q.isEmpty()) {
			int u = q.remove();
			for(int i = 0; i < n; i++) {
				if((u & (1 << i)) == 0) {
					for(int j = i+1; j < n && (u & (1 << j)) > 0; j++) {
						int v = u + (1 << i) - (1 << j);
						if(v < m && dist[v] < 0) {
							dist[v] = dist[u] + 1;
							q.add(v);
						}
					}
				}
			}
			for(int i = n-1; i >= 0; i--) {
				if((u & (1 << i)) == 0) {
					for(int j = i-1; j >= 0 && (u & (1 << j)) > 0; j--) {
						int v = u + (1 << i) - (1 << j);
						if(v < m && dist[v] < 0) {
							dist[v] = dist[u] + 1;
							q.add(v);
						}
					}
				}
			}
		}
		System.out.println(dist[Integer.parseInt(t, 2)]);
		}
	}

}
